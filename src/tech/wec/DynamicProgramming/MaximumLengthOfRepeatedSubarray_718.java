package tech.wec.DynamicProgramming;

public class MaximumLengthOfRepeatedSubarray_718 {
    class Solution {
        public int findLength(int[] A, int[] B) {
            int[][] dp = new int[A.length + 1][B.length + 1];
            int ans = 0;
            for (int i = A.length - 1; i >= 0; i--){
                for (int j = B.length - 1; j >= 0; j--){
                    if (A[i] == B[j]) dp[i][j] = dp[i+1][j+1] + 1;
                    if (ans < dp[i][j]) ans = dp[i][j];
                }
            }
            return ans;
        }
    }
}
