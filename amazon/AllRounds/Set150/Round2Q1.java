package amazon.AllRounds.Set150;

public class Round2Q1 {

	/**
	 * @param args
	 * http://www.geeksforgeeks.org/find-number-of-islands/
	 */
	static int maxArea = Integer.MIN_VALUE;
	static int a = 0;
	public static void main(String[] args) {
		
		int[][] mat = {
						{1, 1, 0, 0, 0},
		                {0, 1, 0, 0, 1},
		                {1, 0, 0, 1, 1},
		                {0, 0, 0, 0, 0},
		                {1, 0, 1, 0, 1}
		              };
		int col = 5;
		int row = 5;
		Round2Q1 rq2 = new Round2Q1();
		int count = rq2.numberOfIslandFloodFill(mat);
		System.out.println(count);
		//rq2.island(mat, row, col);

	}

	
	public boolean isSafe(int[][] mat,int y,int x,boolean[][] isVisited,int row,int col){
		try{
			if(x >= 0 && x < col && y >= 0 && y < row && mat[y][x] == 1 && !isVisited[y][x]){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public void traverse(int[][] mat,int i,int j,boolean[][] isVisited,int row,int col){
		try{
			
			int[] x = { 0 , 1 , 1 , 1 , 0 , -1 , -1 , -1};
			int[] y = { 1 , 1 , 0 ,-1 ,-1 , -1 ,  0 , 1};
			isVisited[i][j] = true;
			
			for(int l = 0 ; l < 8 ; l++){
				if(isSafe(mat, i+y[l],j+x[l], isVisited, row, col)){
					a++;
					traverse(mat, i+y[l],j+x[l], isVisited, row, col);
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}
	
	public void island(int[][] mat,int row,int col){
		try{
			boolean[][] isVisited = new boolean[row][col];
			int count = 0;
			for(int i = 0;i<row;i++){
				for(int j = 0;j<col;j++){
					if(mat[i][j] == 1 && !isVisited[i][j]){
						traverse(mat, i, j, isVisited, row, col);
						if(maxArea < a){
							maxArea = a;
							a = 0;
						}
						count++;
					}
				}
			}
			System.out.println("No. Of Island > "+count + ", max area of the island > "+maxArea);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int numberOfIslandFloodFill(int[][] mat){
		try{
			int count = 0;
			int col = 5;
			int row = 5;
			boolean[][] visited = new boolean[row][col];
			for(int i = 0;i<row;i++){
				for(int j = 0;j<col;j++){
					if(mat[i][j] == 1 && !visited[i][j]){
						byFloodFill(mat, i, j, row, col, visited);
						count++;
					}
				}
			}
			return count;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public void byFloodFill(int[][] mat,int x,int y,int row,int col,boolean[][] visited){
		try{
			if(x < 0 || y > col || x> row || y < 0){
				return;
			}
			
			if(x >= 0 && y >= 0 && x < row && y < col && mat[x][y] == 1 && visited[x][y] == false){
				visited[x][y] = true;
				byFloodFill(mat, x+1, y, row, col, visited);
				byFloodFill(mat, x-1, y, row, col, visited);
				byFloodFill(mat, x+1, y+1, row, col, visited);
				byFloodFill(mat, x+1, y-1, row, col, visited);
				byFloodFill(mat, x-1, y-1, row, col, visited);
				byFloodFill(mat, x-1, y+1, row, col, visited);
				byFloodFill(mat, x, y+1, row, col, visited);
				byFloodFill(mat, x, y-1, row, col, visited);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
