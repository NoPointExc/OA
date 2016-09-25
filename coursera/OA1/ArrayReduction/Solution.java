import java.util.*;

class Solution{
    
    public int minSum(int[] arr){
	int sum = 0;
	if(arr.length == 0)
	    return sum;
	
	PriorityQueue<Integer> queue = new PriorityQueue<>();
	for(int n:arr)
	    queue.add(n);
	
	while(queue.size()>1){
	    int tmp = queue.poll() + queue.poll();
	    queue.offer(tmp);
	}

	return queue.poll();
    } 

    public static void main(String[] args){
	int len = args.length;
	int[] arr = new int[len];
	
	for(int i=0;i<len;i++)
	    arr[i] = Integer.valueOf(args[i]);
	
	Solution s = new Solution();
	int rst = s.minSum(arr);
	System.out.println("rst="+rst);
    }
}
