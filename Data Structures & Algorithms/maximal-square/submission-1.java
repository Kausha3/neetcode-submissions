class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxLength = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int[] arr: cache) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int find = recurse(i, j, matrix, cache);
                    maxLength = Math.max(maxLength, find);
                }
            }
        } 
        return maxLength * maxLength; 
    }

    private int recurse(int row, int col, char[][] matrix, int[][] cache) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == '0')
            return 0;
        
        if (cache[row][col] != -1) return cache[row][col];
        int found = 1 + Math.min(recurse(row + 1, col, matrix, cache), Math.min(recurse(row + 1, col + 1, matrix, cache), recurse(row, col + 1, matrix, cache)));
        return cache[row][col] = found;
    }
}