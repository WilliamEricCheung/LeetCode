package tech.wec.Array;

public class SpiralMatrixII_59 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int loop = 0;
            int start = 0;
            int num = 1;
            int i, j;
            while (loop++ < n / 2) {
                for (j = start; j < n - loop; j++) {
                    result[start][j] = num++;
                }
                for (i = start; i < n - loop; i++) {
                    result[i][j] = num++;
                }
                for (; j >= loop; j--) {
                    result[i][j] = num++;
                }
                for (; i >= loop; i--) {
                    result[i][j] = num++;
                }
                start++;
            }
            if (n % 2 == 1) {
                result[start][start] = num;
            }
            return result;
        }
    }
}
