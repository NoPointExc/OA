import java.util.*;

public class Solution{
	//just final result. comman devider
	public List<Integer> getFinalRst(int[] arr){
		List<Integer> list = new LinkedList<>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean gotMin = false;
		
		while(!gotMin){
			for(int n:arr){
				max = Math.max(max,n);
				if(n%min!=0 && n%min<min){
					 min = n%min;
					 gotMin = true;
				}
			}	
		}

		for(int i=min;i<=max;i+=min)
			list.add(i);

		return list;
	}

	//all middle result . loops.
	public List<List<Integer>> getAllRst(int[] arr){
		int l=0, r =1;
		List<List<Integer>> lists = new LinkedList<>();
		ArrayList<Integer> curList = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		for(int n:arr){
			curList.add(n);
			set.add(n);
		}

		while(r<curList.size()){
			while(l<r){
				int diff = Math.abs(curList.get(l) - curList.get(r));
				while( l<r && (diff==0 || set.contains(diff)) ){
					l++;
					diff = Math.abs(curList.get(l) - curList.get(r));
				}
				if(l==r) continue;
				curList.add(diff);
				lists.add(curList);
				curList = new ArrayList<>(curList);
				set.add(diff);
				l++;
			}
			r++;
			l=0;
		}

		return lists;
	}

	public static void main(String[] args){
		//int[] arr = {2,7,5};
		int[] arr = {3,6,9,2};
		//List<Integer> rst = new Solution().getFinalRst(arr);
		List<List<Integer>> rst = new Solution().getAllRst(arr);
		for(List<Integer> lst:rst)
			System.out.println(lst);
	}

}