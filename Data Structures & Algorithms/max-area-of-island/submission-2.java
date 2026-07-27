class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 1) {
                    int areaFound = dfs(grid, i, j, visited);
                    maxArea = Math.max(maxArea, areaFound);
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    private int dfs(int[][] grid, int row, int col, int[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] == 1 || grid[row][col] == 0) {
            return 0;
        }
        visited[row][col] = 1;
        int count = 1;

        count += dfs (grid, row - 1, col, visited);
        count += dfs (grid, row + 1, col, visited);
        count += dfs (grid, row, col + 1, visited);
        count += dfs (grid, row, col - 1, visited);
            
        
        return count;
    }

}
