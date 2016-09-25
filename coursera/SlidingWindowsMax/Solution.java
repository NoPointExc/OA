import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
	if(k<=0)
	    return new int[0];
	int[] rst = new int[nums.length-k+1];
	//save index of values which bigger than nums[i]
	Deque<Integer> queue = new LinkedList<>();

	for(int i=0;i<nums.length;i++){
	    if(!queue.isEmpty() && queue.peek()<i-k+1)
		queue.poll();

	    while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i] )
		queue.pollLast();
	    
	    queue.offer(i);
	    if(i>=k-1)
		rst[i-k+1] = nums[queue.peek()];
	}

	return rst;
    }
}

