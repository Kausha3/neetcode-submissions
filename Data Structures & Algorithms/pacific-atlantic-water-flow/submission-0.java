class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        	int row = heights.length;
		int col = heights[0].length;

	boolean[][] pac = new boolean[row][col]; 
boolean[][] atl = new boolean[row][col];
		
		for (int r = 0; r < row; r++) {
			dfs(r, 0, pac, heights[r][0], heights);
			dfs(r, col - 1, atl, heights[r][col - 1], heights);
		}

		for (int c = 0; c < col; c++) {
			dfs(0, c, pac, heights[0][c], heights);
			dfs(row - 1, c, atl, heights[row - 1][c], heights);
		}

		List<List<Integer>> result = new ArrayList<>();

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (pac[r][c] && atl[r][c]) {
					result.add(Arrays.asList(r, c));
				}
			}
		}
		return result;
		
	}

	private void dfs(int row, int col, boolean[][] visited, int prevHeight, int[][] heights) {
		if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || heights[row][col] < prevHeight || visited[row][col] == true) return;

		visited[row][col] = true;

		dfs(row + 1, col, visited, heights[row][col], heights);
		dfs(row - 1, col, visited, heights[row][col], heights);
		dfs(row, col + 1, visited, heights[row][col], heights);
		dfs(row, col - 1, visited, heights[row][col], heights);
	}

}

