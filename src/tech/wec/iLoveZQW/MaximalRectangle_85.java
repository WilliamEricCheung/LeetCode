package tech.wec.iLoveZQW;

import java.util.Arrays;

public class MaximalRectangle_85 {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0) return 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int[] left = new int[n];
            int[] right = new int[n];
            int[] height = new int[n];
            Arrays.fill(right, n); // init right as the rightmost boundary
            int max = 0;
            for (int i = 0; i < m; i++){
                int curLeft = 0, curRight = n;
                // update height
                for (int j = 0; j < n; j++){
                    if (matrix[i][j] == '1') height[j]++;
                    else height[j] = 0;
                }
                // update left
                for (int j = 0; j < n; j++){
                    if (matrix[i][j] == '1') left[j] = Math.max(left[j], curLeft);
                    else{
                        left[j] = 0;
                        curLeft = j + 1;
                    }
                }
                // update right
                for (int j = n - 1;j >= 0; j--){
                    if (matrix[i][j] == '1') right[j] = Math.min(right[j], curRight);
                    else{
                        right[j] = n;
                        curRight = j;
                    }
                }
                //update area
                for (int j = 0; j < n; j++){
                    max = Math.max(max, (right[j] - left[j]) * height[j]);
                }
            }
            return max;
        }
    }
}
