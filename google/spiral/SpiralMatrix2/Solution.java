public class Solution {
    private final static int[] R_VTR = {0,1};
    private final static int[] D_VTR = {1,0};
    private final static int[] L_VTR = {0,-1};
    private final static int[] U_VTR = {-1,0};

    private final static int[][] DIRECTION = {R_VTR, D_VTR, L_VTR, U_VTR};

    public int[][] generateMatrix(int n) {
	if(n==0)
	    return int[0][0];
	int[][] rst = new int[n][n];
	boolean[][] visitMap = new boolean[n][n];
	int visited = 0;
	int dirIndex = 0;
	int[] direction = DIRECTION[dirIndex];
	int[] location = {0,0};

	while(visited<n*n){
	    visited++;
	    rst[ location[0] ][ location[1] ] = visited;
	    visitMap[ location[0] ][ location[1] ] = true;
	    int nextX = location[0] + direction[0];
	    int nextY = location[1] + direction[1];

	    //turn direction
	    if(nextX<0 || nextX>=n || nextY<0 || nextY>=n || visitMap[nextX][nextY]){
		dirIndex++;
		if(dirIndex>3)
		    dirIndex = 0;
		direction = DIRECTION[dirIndex];
	    }

	    //go to next
	    location[0] += direction[0];
	    location[1] += direction[1];
	}

	return rst;
    }

    public static void main(String[] arg){
	Solution s = new Solution();
	if(arg.length<1)
	    return;
	int n = Integer.parseInt(arg[0]);
	int[][] rst = s.generateMatrix(n);
	print(rst);	
    }

    public static void print(int[][] arr){
	for(int i=0;i<arr.length;i++){
	    for(int j=0;j<arr[0].length;j++)
		System.out.print(arr[i][j]+" ");
	    System.out.println();
	}
    }
}

