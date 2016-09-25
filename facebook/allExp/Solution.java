import java.util.*;

class Solution{
    private static final char[] SIGN = {' ','+','-'};

    public List<String> getExper(String num){
	LinkedList<String> experations = new LinkedList<>();
	if(num.length()==0)
	    return experations;
	
	//permute
	List<String> permutedNum = permute(num);
	//System.out.println(permutedNum);
	
	//add sign
	Queue<String> queue = new LinkedList<>(permutedNum);
	int len = num.length();	
	for(int i=num.length();i<len*2;i++){
	    while(queue.peek().length()==i){
		//keep poll
		String next = queue.poll();
		for(char sign:SIGN){
		   if(i-len ==0 && sign == '+') continue; 
		   queue.offer( addCharToStr(next,2*(i-len),sign) ); 
		}
	    }
	}

	//trim
	for(String s:queue){
	    s = s.replaceAll(" ","");
	    experations.add(s);
	}

	return experations; 
    }

    public String addCharToStr(String str, int pos, char chr){
	String left = str.substring(0,pos);
	String right = str.substring(pos);
	StringBuilder sb = new StringBuilder();
	String rst = sb.append(left).append(chr).append(right).toString();
	//System.out.println("str"+str+" pos"+pos+" "+rst);
	return rst;
    }

    public List<String> permute(String num){
	List<String> list = new ArrayList<>();
	permute(list,num.toCharArray(),0);
	return list;
    }

    private void permute(List<String> list, char[] num, int k){

	if(k==num.length-1){
	    StringBuilder sub = new StringBuilder();
	    for(char n:num){	
		sub.append(n);
	    }
	    list.add(sub.toString());
	}else{
	    HashSet<Character> reached = new HashSet<> (); 
	    for(int i=k;i<num.length;i++){
		if(reached.contains(num[i]))
		    continue;
		reached.add(num[i]);
		swap(num,k,i);
		permute(list,num,k+1);
		swap(num,k,i); // swap back
	    }
	}
    }

    private void swap(char[] arr,int i, int j){
	char tmp = arr[i];
	arr[i] = arr[j];
	arr[j] =tmp;
    }

    public static void main(String[] args){
	if(args.length<1)
	    return;
	Solution s = new Solution();
	//String rst = s.addCharToStr("abcde", 1, '1');
	//List<String> rst = s.permute(args[0]);	
	List<String> rst = s.getExper(args[0]);
	System.out.println(rst);
    }

    public static void print(List<List<Character>> list){
	for(List<Character> lst : list){
	    for(char c:lst){
		System.out.print(c);
	    }
	    System.out.println();
	}
    }
}
