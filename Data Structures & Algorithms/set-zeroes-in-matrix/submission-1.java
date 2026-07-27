class Solution {
    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[k][j] != 0)
                            matrix[k][j] = -1;
                    }

                    for (int l = 0; l < matrix[0].length; l++) {
                        if (matrix[i][l] != 0)
                            matrix[i][l] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
