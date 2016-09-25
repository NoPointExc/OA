class Solution{
    public int isLovely(int num){
	if(num == 0) 
	    return -1;
	int len = 0;
	int n = num;
	while(n!=0){
	    n = n>>1;
	    len++;
	}

	if(len%2==0){
	    int rightHalf = num>>(len/2);
	    int leftHalf = rightHalf<<(len/2);
	    if(leftHalf+rightHalf == num) 
		return rightHalf;
	}

	return -1;
    }
    
    public static void main(String[] args){
	if(args.length ==0 )
	    return;
	int in = Integer.parseInt(args[0]);
	Solution s = new Solution();
	System.out.println("rst="+s.isLovely(in));
    } 
}
