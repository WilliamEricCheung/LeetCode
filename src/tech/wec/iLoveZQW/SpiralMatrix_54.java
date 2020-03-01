package tech.wec.iLoveZQW;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            if (matrix.length == 0) return ans;
            int top = 0, bottom = matrix.length-1;
            int left = 0, right = matrix[0].length-1;
            while(top <= bottom && left <= right){
                for (int i = left; i <= right; i++)
                    ans.add(matrix[top][i]);
                for (int i = top + 1; i <= bottom; i++)
                    ans.add(matrix[i][right]);
                if (top < bottom && left < right) {
                    for (int i = right - 1; i > left; i--)
                        ans.add(matrix[bottom][i]);
                    for (int i = bottom; i > top; i--)
                        ans.add(matrix[i][left]);
                }
                top++; bottom--;
                left++; right--;
            }
            return ans;
        }
    }
}
