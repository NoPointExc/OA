class Solution{
    
    public String maxStr(String[] arr){
	if(arr.length ==0 )
	    return null;
	String rst = "";
	for(int i=0;i<arr.length;i++){
	    if(compare(arr[i],rst)>0){
		rst = arr[i];
	    }
	}	
	return rst;
    } 
    
    public int compare(String str1, String str2){
	
	for(int i=0;i<str1.length()&&i<str2.length();i++){
	    if(str1.charAt(i)!=str2.charAt(i)){
		return str1.charAt(i) - str2.charAt(i);
	    }    
	}
	
	return str1.length()-str2.length();
    }

    public static void main(String[] args){
	Solution s = new Solution();
	String rst = s.maxStr(args);
	System.out.println("rst="+rst);
    }
}
