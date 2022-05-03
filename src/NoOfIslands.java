
public class NoOfIslands {

	public static void main(String[] args) {
		char[][] grid = new char[5][6];
//		[["1","1","1","1","1","1"],["1","0","0","0","0","1"],["1","0","1","1","0","1"],["1","0","0","0","0","1"],["1","1","1","1","1","1"]]
//		grid[0] = new char[]; 
//		char[] x1 = { '1', '1', '1', '1', '0' };
//		grid[0] = x1;
//		char[] x2 = { '1', '1', '0', '1', '0' };
//		grid[1] = x2;
//		char[] x3 = { '1', '1', '0', '0', '0' };
//		grid[2] = x3;
//		char[] x4 = { '0', '0', '0', '0', '0' };
//		grid[3] = x4;
		//
		char[] x1 = { '1', '1', '1', '1', '1', '1' };
		grid[0] = x1;
		char[] x2 = { '1', '0', '0', '0', '0', '1' };
		grid[1] = x2;
		char[] x3 = { '1', '0', '1', '1', '0', '1' };
		grid[2] = x3;
		char[] x4 = { '1', '0', '0', '0', '0', '1' };
		grid[3] = x4;
		char[] x5 = { '1', '1', '1', '1', '1', '1' };
		grid[4] = x5;
		//
//		char[] x1 = { '1', '1', '1' };
//		grid[0] = x1;
//		char[] x2 = { '1', '0', '1'};
//		grid[1] = x2;
//		char[] x3 = { '1', '1', '1' };
//		grid[2] = x3;

		System.out.println(numIslands(grid));
	}

	static public int numIslands(char[][] grid) {

		int count = 0; // var to count the islands
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') { // if we find one, we call a function to check forward
					dfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(char[][] grid, int i, int j) {

		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
			return;

		grid[i][j] = '0'; // set your current pos to zero, and explore in its four directions
		dfs(grid, i, j + 1); // right side
		dfs(grid, i + 1, j); // down-side
		dfs(grid, i, j - 1); // left-side
		dfs(grid, i - 1, j); // up-side
	}

}
