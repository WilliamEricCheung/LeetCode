package tech.wec.Google;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Arrays;
import java.util.List;

public class RangeSumQuery2DMutable {
    /**
     * we store the prefix sum for each row from the matrix
     * for sum operation we only need to do a substraction to get sum of each row from col1 to col2, so total is O(n)
     * for a update, we update the prefix sum of the row has updated value, so total is O(n)
     */
    class NumMatrix {

        private int rows = 0, cols = 0;
        private int[][] prefixSum;
        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            rows = matrix.length;
            cols = matrix[0].length;
            prefixSum = new int[rows][cols];
            for (int i = 0; i < rows; i++){
                int[] sum = new int[cols];
                Arrays.fill(sum, 0);
                sum[0] = matrix[i][0];
                for (int j = 1; j< cols; j++){
                    sum[j] = sum[j - 1] + matrix[i][j];
                }
                prefixSum[i] = sum;
            }
            this.matrix = matrix;
        }

        public void update(int row, int col, int val) {
            if (row > rows || col > cols)
                return;
            int diff = val - matrix[row][col];
            for (int i= col; i < cols; i++){
               prefixSum[row][i] += diff;
            }
            matrix[row][col] = val;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int total = 0;
            for (int i = row1; i<=row2;i++){
                total += prefixSum[i][col2];
                if (col1 != 0){
                    total -= prefixSum[i][col1 - 1];
                }
            }
            return total;
        }
    }
}
