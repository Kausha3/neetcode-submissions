class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, 1, -1, 0};

        boolean[][] visited = new boolean[n][m];

        for(int j = 0; j < m; j++) {
            if(board[0][j] == 'O' && !visited[0][j]) {
                visited[0][j] = true;
                dfs(board, visited, 0, j, di, dj);
            }
            if (board[n-1][j] == 'O' && !visited[n-1][j]) {
                visited[n-1][j] = true;
                dfs(board, visited, n-1, j, di, dj);
            }
        }
            
        for(int j = 0; j < n; j++) {
            if (board[j][0] == 'O' && !visited[j][0]) {
                visited[j][0] = true;
                dfs(board, visited, j, 0, di, dj);
            }

           

            if (board[j][m-1] == 'O' && !visited[j][m-1]) {
                visited[j][m-1] = true;
                dfs(board, visited, j, m-1, di, dj);
            }
        
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, int[] di, int[] dj) {
        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];

            if(ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                if(board[ni][nj] == 'O' && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    dfs(board, visited, ni, nj, di, dj);
                }
            }
        }
    }
}
