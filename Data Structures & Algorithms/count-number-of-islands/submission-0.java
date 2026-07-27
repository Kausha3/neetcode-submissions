class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) { 
                if(grid[i][j] == '1') {
                    if(visited[i][j] != true) {
                        islands++;
                        visited[i][j] = true;
                        dfs(grid, visited, i, j);
                    }
                }

            }
        }
        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int currRow, int currCol) {
        if(currRow + 1 < grid.length) { 
            if(grid[currRow + 1][currCol] == '1') {
                if(!visited[currRow + 1][currCol]) {
                    visited[currRow + 1][currCol] = true;
                    dfs(grid, visited, currRow + 1, currCol);
                }
            }
        }
            if(currRow - 1 >= 0) {

            if(grid[currRow - 1][currCol] == '1') {
                if(!visited[currRow - 1][currCol]) {
                    visited[currRow - 1][currCol] = true;
                    dfs(grid, visited, currRow - 1, currCol);
                }
            }
            }
            if(currCol + 1 < grid[0].length) {
                if(grid[currRow ][currCol + 1] == '1') {
                    if(!visited[currRow ][currCol + 1]) {
                        visited[currRow ][currCol + 1] = true;
                        dfs(grid, visited, currRow, currCol + 1);
                    }
                }
            }
            if(currCol - 1 >= 0 ){
                if(grid[currRow ][currCol - 1] == '1') {
                    if(!visited[currRow ][currCol - 1]) {
                        visited[currRow ][currCol - 1] = true;
                        dfs(grid, visited, currRow , currCol - 1);
                    }
                }
            }
    }
}
