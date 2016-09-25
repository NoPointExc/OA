class Solution{
    private final static int[][] DIRECTION = {{0,-1},{0,1},{-1,0},{1,0}};//left,right,up,down
    
    public int countRoute(int[][] matrix, int x, int y, int k){
	if(matrix.length == 0 || matrix[0].length ==0 )
	    return k==0?1:0;
	if(k==0)
	    return (x==0 && y==0)?1:0;
	int wid = matrix.length;
	int len = matrix[0].length;

	int[][][] dp = new int[k+1][wid][len];
	dp[0][0][0] = 1;

	for(int s=1;s<=k;s++){
	    for(int i=0;i<wid;i++){
		for(int j=0;j<len;j++){
		    //f(x,y,k) = f(x-1,y,k-1) + f(x,y-1,k-1) + f(x+1,y,k-1) + f(x,y+1,k-1)
		    for(int f=0;f<DIRECTION.length;f++){
			int lastX = i - DIRECTION[f][0];
			int lastY = j - DIRECTION[f][1];
			if(lastX>=0 && lastX<wid && lastY>=0 && lastY<len && dp[s-1][lastX][lastY]>0){
			    if(s==1)
				dp[s][i][j] += dp[s-1][lastX][lastY];
			    else
				dp[s][i][j] += dp[s-1][lastX][lastY] - dp[s-2][i][j];
			}
		    }
		}
	    }
	    //System.out.println("-----s="+s+"--------");
	    //print(dp[s]);
	}

	return dp[k][x][y];
    }

    public static void main(String[] args){
	Solution s = new Solution();
	int[][] matrix = new int[4][4];
	int x = 0;
	int y = 1;
	int k = 4;
	int rst = s.countRoute(matrix,x,y,k);
	System.out.println(rst);
		
    }

    public static void print(int[][] arr){
    
	for(int i=0;i<arr.length;i++){
	    for(int j=0;j<arr[0].length;j++){
		System.out.print(arr[i][j]+" ");
	    }
	    System.out.println();
	}

	System.out.println("-------------");
    }

}
