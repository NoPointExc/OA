import java.util.*;

class Solution{
    private static String[] MAP = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
	List<String> rst = new ArrayList<String>();
	if(digits.length()==0)
	    return rst;
	int[] nums = toNums(digits);
	backTracking(rst,"",nums,0);	
	return rst;
    }

    private void backTracking(List<String> list, String str, int[] nums, int k){
	if(k==nums.length){
	    list.add(str);
	}else{
	    char[] charPool = MAP[nums[k]].toCharArray();
	    for(char c:charPool){
		backTracking(list,str+c,nums,k+1);
	    }
	}
    }
    
    private int[] toNums(String digits){
	int[] rst = new int[digits.length()];
	
	for(int i=0;i<digits.length();i++){
	    rst[i] = digits.charAt(i)-'0';
	}

	return rst;
    }

    public static void main(String[] args){
	Solution s = new Solution();
	List<String> rst = s.letterCombinations(args[0]);
	System.out.println(rst);
    }
}
