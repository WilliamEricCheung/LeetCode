package tech.wec.Facebook;

public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0;i<=(n-1)/2;i++){
            for (int j = 0;j<=n/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i]; // bottom to left
                matrix[n-j][i] = matrix[n-i][n-j]; // right to bottom
                matrix[n-i][n-j] = matrix[j][n-i]; // top to right
                matrix[j][n-i] = tmp; // left to top
            }
        }
    }
}
