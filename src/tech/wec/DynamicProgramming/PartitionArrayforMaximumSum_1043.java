package tech.wec.DynamicProgramming;

public class PartitionArrayforMaximumSum_1043 {

    public int maxSumAfterPartitioning(int[] A, int K) {
        if (A.length == 0) return 0;
        int[] dp = new int[A.length];
        int max = A[0];
        for (int i = 0; i < K; i++){
            max = Math.max(max, A[i]);
            dp[i] = (i+1) * max;
        }
        for (int i = K; i < A.length; i++){
            max = A[i];
            for (int j = 0; j < K; j++){
                max = Math.max(max, A[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j - 1] + (j + 1) * max);
            }
        }
        return dp[A.length - 1];
    }
}
