import java.util.*;

//launch_date , repeat_frequency, enrollment_date

class Solution{
	private static final long ONE_DAY_MILLIS = 24*60*60*1000;
	private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
	
	static{
		TimeZone.setDefault(GMT);
	}

	public long[] getSessionSchedule(long launch_date,int repeat_frequency, long enrollment_date){
		long[] list = new long[3];
		//should throws a exception here
		if(launch_date<0 || enrollment_date < 0)
			return list;

		Calendar launchCal = new GregorianCalendar(GMT);;
		launchCal.setTimeInMillis(launch_date);
		Calendar enrollCal = new GregorianCalendar(GMT);
		enrollCal.setTimeInMillis(enrollment_date);
		//get 1st session after launch_date
		long sessionDate = launchCal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY?launch_date:nextSession(nextMonday(launch_date),repeat_frequency);
		while( needWait(enrollment_date,sessionDate,repeat_frequency) ){
			sessionDate = nextSession(sessionDate,repeat_frequency);	    
		}

		Calendar sessionCal = new GregorianCalendar(GMT);
		for(int i=0;i<list.length;i++){
			sessionCal.setTimeInMillis(sessionDate);
			list[i] = sessionCal.getTimeInMillis();
			sessionDate = nextSession(sessionDate,repeat_frequency);
		}

		return list;
	}

	private boolean needWait(long enrollDate, long sessionDate, int frequency){
		int waitDays = daysBetween(enrollDate,sessionDate); //sessiondate - enrolldate
		return waitDays<0  ;
	}
	
	private int daysBetween(long d1, long d2){
 		return (int)( (d2- d1) / (1000 * 60 * 60 * 24));
 	}

	private long nextSession(long curSession, int frequency){
		for(int i=0;i<frequency;i++){
				curSession = nextMonday(curSession);		
		}
		return curSession;
	}


    //add to next monday(if it is monday, add one week)
	private long nextMonday(long date){
		Calendar cal = new GregorianCalendar(GMT);
		cal.setTimeInMillis(date);

		int addDays = 0;

		if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY)
			addDays = 7; 
		else if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
			addDays = 1;
		else
			addDays =Calendar.SATURDAY - cal.get(Calendar.DAY_OF_WEEK) + Calendar.MONDAY - Calendar.SUNDAY +1 ; 
		cal.add(Calendar.DAY_OF_MONTH,addDays);
		return cal.getTimeInMillis();
	}

	public static void main(String[] args){
		long launch_date = 1470700800000L;
		int frequency = 1;
		long enrollment_date = 1470096000000L;
		
		Solution s = new Solution();
		
		Calendar cal = new GregorianCalendar(GMT);
		cal.setTimeInMillis(launch_date);
		System.out.println( "launch_date="+launch_date + " " + cal.getTime().toString());
		cal.setTimeInMillis(enrollment_date);	
		System.out.println("enrollment_date="+enrollment_date +" " + cal.getTime().toString());
		long[] rst = s.getSessionSchedule(launch_date,frequency,enrollment_date);

		System.out.println("===============;)");
		
		for(long r:rst){
			Date date = new Date(r);
			System.out.println(r+" "+date.toString());
		}

		//System.out.println(s.nextMonday(new Date(launch_date)).toString());
		//System.out.println(s.nextSession(s.nextMonday(new Date(launch_date)),frequency).toString());
			
	}
}
