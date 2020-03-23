package tech.wec.iLoveZQW;

public class RotateImage_48 {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length - 1;
            for (int i = 0; i <= (n - 1) / 2; i++){
                for (int j = 0; j <= n / 2; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n-j][i];
                    matrix[n-j][i] = matrix[n-i][n-j];
                    matrix[n-i][n-j] = matrix[j][n-i];
                    matrix[j][n-i] = temp;
                }
            }
        }
    }
}
