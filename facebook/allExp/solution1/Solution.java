import java.util.*;

class Solution{
    
    public List<String> getAllComb(String num){
	List<String> rst = new ArrayList<>();
	if(num.length() ==0 )
	    return list;	
	//1. get all combination
	List<List<String>> comb = premute(num);
	//2. add +/-
	rst = getExp(comb);

	return rst;
    }
    
    private List<List<String>> getExp(List<List<String>> comb){
	List<String> rst = new LinkedList<>();
	if(comb.size()==0)
	    return rst;
	
	int len = comb.size();
	int wid = Math.pow(2,len);
	//==0 is false
	boolean[][] isPlus = new boolean[wid][len];
	for(int i = 0;i<wid; i++){
	    for(int num = i, j=0;num!=0;num = num>>1,j++){
		isPlus[i][j] = num%2 != 0;	
	    }
	}
	
	int i=0,j=0;
	for(List<List<String>> lst: comb){
	    StringBuilder sb = new StringBuilder();
	    for(String s:lst){
		if(!isPlus[i][j]){
		    sb.append("-");
		}else if(j!=0){
		    sb.append("+");
		}
		sb.append(s);
		j++;
	    }
	    rst.add(sb.toString());
	    i++;
	}

	return rst;
    }

    private List<List<String>> premute(String s){
	List<List<String>> rst = new ArrayList<List<String>>();
	HashSet<List<String>> map = new HashSet<>();

	if(s.length() == 0)
	    return rst;
	
	if(s.length() == 1){
	    List<String> list = new ArrayList<String>();
	    list.add(s);
	    rst.add(s);
	}else{
	    for(int i=1;i<s.length();i++){
		List<List<String>> subs = premute(s.subString(i));
		for(List<String> list: subs){
		    List<String> tmp = new ArrayList<>(list);
		    tmp.add(0,s.substring(0,i));
		    if(!map.contains(tmp))
			rst.add(tmp);
		    tmp = new ArrayList<>(list);
		    tmp.add(s.substring(0,i));
		    if(!map.contains(tmp))
			rst.add(tmp);
		}
 
	    }
	}

	return rst;
    }

    public static void main(String[] args){
	if(args.length<1) 
	    return;

	Solution s = new Solution();
	List<String> rst = s.getAllComb(args[0]);

	for(String s:rst){
	    System.out.println(s);
	}
    }
}
