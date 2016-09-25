class Solution{
    private final static int[][] DIRECTION = {{0,-1},{0,1},{-1,0},{1,0}};//left,right,up,down

    public int countRoute(int[][] matrix, int x, int y, int k){
	print(matrix);
	System.out.println("x="+x+" y="+y+" k="+k);
	
	int count = 0;
	if(matrix.length ==0 || matrix[0].length==0)
	    return k==0?1:0;

	if(k==0)
	    return (x==0 && y==0)?1:0;
	matrix[x][y] = 1;

	for(int i=0;i<DIRECTION.length;i++){
	    int nextX = x+DIRECTION[i][0];
	    int nextY = y+DIRECTION[i][1];
	    if(nextX>=0 && nextX<matrix.length && nextY>=0 && nextY<matrix[0].length && matrix[nextX][nextY]==0){
		matrix[nextX][nextY] = 1;
		count += countRoute(matrix,nextX,nextY,k-1);
		matrix[nextX][nextY] = 0;
	    }
	}	
	
	return count;
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

    private static void print(int[][] map){
	
	for(int i=0;i<map.length;i++){
	    for(int j=0;j<map[0].length;j++){
		System.out.print(map[i][j]);    
	    }
	    System.out.println();
	}
	

    }
}
