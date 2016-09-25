import java.util.*;

class Solution{

	private static final long ONE_DAY_MILLIS = 24*60*60*1000;
	private static final TimeZone GMT = TimeZone.getTimeZone("GMT");	
	static{
		TimeZone.setDefault(GMT);
	}

	public static long[][] getSpecializationSessionSchedule(long[][] specialization_courses,long enrollment_date){
		long[][] schedule = new long[specialization_courses.length][3];
		long enrollDate = enrollment_date;
		
		for(int i=0;i<specialization_courses.length;i++){
			
			long launchDate = specialization_courses[i][0];
			int frequency = (int)specialization_courses[i][1];
			int duration = (int)specialization_courses[i][2];

			Calendar launchCal = new GregorianCalendar(GMT);
			launchCal.setTimeInMillis(launchDate);
			
			long sessionDate = launchCal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY?launchDate:nextSession(nextMonday(launchDate),frequency);
			while( needWait(enrollDate,sessionDate,frequency) ){
				sessionDate = nextSession(sessionDate,frequency);	    
			}

			long endDate = addWeek(sessionDate,duration);
			schedule[i][0] = sessionDate;
			schedule[i][1] = endDate;
			enrollDate = endDate;
		}

		return schedule;
	}

	public static long addWeek(long startDate,int week){
		Calendar cal = new GregorianCalendar(GMT);
		cal.setTimeInMillis(startDate);
		cal.add(Calendar.DAY_OF_MONTH,7*week);
		return cal.getTimeInMillis();
	}

	private static boolean needWait(long enrollDate, long sessionDate, int frequency){
		Int waitDays = (int)( (sessionDate- enrollDate) / ONE_DAY_MILLIS);
		return waitDays<0  ;
	}
	
	private static int daysBetween(long d1, long d2){
 		return (int)( (d2- d1) / (1000 * 60 * 60 * 24));
 	}

	public static long nextSession(long curSession, int frequency){
		for(int i=0;i<frequency;i++){
				curSession = nextMonday(curSession);		
		}
		return curSession;
	}


    //add to next monday(if it is monday, add one week)
	private static long  nextMonday(long date){
		Calendar cal = new GregorianCalendar(GMT);
		cal.setTimeInMillis(date);

		int addDays = 0;

		if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY)
			addDays = 7; 
		else if(cal.get(Calendar.DAY_OF_WEEK)==Calendar. )
			addDays = 1;
		else
			addDays =Calendar.SATURDAY - cal.get(Calendar.DAY_OF_WEEK) + Calendar.MONDAY - Calendar.SUNDAY +1 ; 
		cal.add(Calendar.DAY_OF_MONTH,addDays);
		return cal.getTimeInMillis();
	}

	public static void main(String[] args) {
		//long[][] specialization_courses = {{1469923200000L,2,4},{1469923200000L,2,4}};
		long[][] specialization_courses = {{1469923200000L,2,4},{1469923100000L-10*ONE_DAY_MILLIS,1,4}};
		
		long enrollment_date = 1470268800000L;
		System.out.println("enrollment_date="+enrollment_date+"  "+new Date(enrollment_date).toString());
		Solution s = new Solution();
		long[][] rst = s.getSpecializationSessionSchedule(specialization_courses,enrollment_date);
		Calendar cal = new GregorianCalendar(GMT);
		
		for(int i=0;i<rst.length;i++){
			String tmp1 = new Date(rst[i][0]).toString();
			String tmp2 = new Date(rst[i][1]).toString();
			System.out.println("startAt="+rst[i][0]+tmp1+"  endAt="+rst[i][1]+tmp2);
		}

		// for(int i=0;i<3;i++){
		// 	enrollment_date = s.addWeek(enrollment_date,1);	
		// 	System.out.println("date="+enrollment_date+" "+new Date(enrollment_date).toString());
		// }

	}
}