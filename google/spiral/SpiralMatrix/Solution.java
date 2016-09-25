import java.util.*;

public class Solution {
    private final static int[] RIGHT = {0,1};
    private final static int[] DOWN = {1,0};
    private final static int[] LEFT = {0,-1};
    private final static int[] UP = {-1,0};
    
    private final static int[][] DIRECTION = {RIGHT,DOWN,LEFT,UP};
    private final static int U=0,R=1,D=2,L=3;
    
    public List<Integer> spiralOrder(int[][] matrix) {
	List<Integer> list = new LinkedList<Integer>();
	if(matrix.length==0 || matrix[0].length==0)
	    return list;
	
	int[] pos = {0,0};
	int dir = 0;
	int left = 0, right = matrix[0].length, top = 0, down = matrix.length;
	int num = right*down;
	int count = 0;
	
	while(count < num){
	    list.add(matrix[pos[0]][pos[1]]);
	    count++;
	    int x = pos[0] + DIRECTION[dir][0];
	    int y = pos[1] + DIRECTION[dir][1];
	     
	    if(!(y>=left &&y<right && x>=top && x<down)){
		//shrik border
		switch(dir){
		    case 0:
			top++;
			break;
		    case 1:
			right--;
			break;
		    case 2:
			down--;
			break;
		    case 3:
			left++;
		}	
		
		//chage direction
		dir++;
		if(dir==DIRECTION.length)
		    dir = 0;
	    }

	    pos[0] += DIRECTION[dir][0];
	    pos[1] += DIRECTION[dir][1];
	}

	return list;
    }

    public static void main(String[] args){
	Solution s = new Solution();
	int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
	List<Integer> lst = s.spiralOrder(matrix);
	System.out.println(lst);
    }
}

