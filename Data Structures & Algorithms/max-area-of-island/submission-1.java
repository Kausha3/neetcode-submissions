class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 1) {
                    visited[i][j] = 1;
                    int areaFound = dfs(grid, i, j, visited, 1);
                    maxArea = Math.max(maxArea, areaFound);
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    private int dfs(int[][] grid, int row, int col, int[][] visited, int count) {
        if (row - 1 >= 0) {
            if (grid[row - 1][col] == 1 && visited[row - 1][col] != 1) {
                visited[row - 1][col] = 1;
                count += dfs (grid, row - 1, col, visited, 1);
            }
        }

        if (row + 1 < grid.length) {
            if (grid[row + 1][col] == 1 && visited[row + 1][col] != 1) {
                visited[row + 1][col] = 1;
                count += dfs (grid, row + 1, col, visited, 1);
            }
        }

        if (col + 1 < grid[0].length) {
            if (grid[row][col + 1] == 1 && visited[row][col + 1] != 1) {
                visited[row][col + 1] = 1;
                count += dfs (grid, row, col + 1, visited, 1);
            }
        } 

         if (col - 1 >= 0) {
            if (grid[row][col - 1] == 1 && visited[row][col - 1] != 1) {
                visited[row][col - 1] = 1;
                count += dfs (grid, row, col - 1, visited, 1);
            }
        }
        return count;
    }

}
