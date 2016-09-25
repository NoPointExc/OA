class Solution{
    
    public boolean nSum(int[] arr, int target){
	if(arr.length==0)
	    return target == 0;
	int sum = 0;
	int l =0, r = 0;
	
	while(l<arr.length){
	    if(sum == target){
		return true;
	    }else if(sum>target && l<r){
		sum -= arr[l];
		l++;
	    }else if(r<arr.length){
		sum += arr[r];
		r++;
	    }else{
		break;
	    }
	}

	return false;
    }

    public static void main(String[] args){
	Solution s = new Solution();
	int[] arr ={1,1,2,4,8,3,3,2,4,5};
	int target = 10;
	boolean rst = s.nSum(arr,target);
	System.out.println(rst);
    }
}
