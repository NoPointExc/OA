class Solution{
    
    int getSmallest(int num){
	String str = String.valueOf(num);
	int min = num;
	
	for(int r=1;r<str.length();r++){
	    int l = r -1;
	    StringBuilder sb = new StringBuilder(str);
	    int tmp =str.charAt(l)<str.charAt(r) ? Integer.parseInt(sb.deleteCharAt(l).toString()):Integer.parseInt(sb.deleteCharAt(r).toString());
	    min = Math.min(min,tmp);
	}
	return min;
    }

    public static void main(String[] args){
	if(args.length<1)
	    return;
	
	int num = Integer.parseInt(args[0]);
	Solution s = new Solution();
	System.out.println("rst="+s.getSmallest(num));
    } 
}
