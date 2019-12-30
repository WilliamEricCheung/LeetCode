package tech.wec.DynamicProgramming;

import java.util.Arrays;

public class MaximumSumOfTwoNonOverlappingSubarrays_1031 {
    class Solution {
        public int maxSumTwoNoOverlap(int[] A, int L, int M) {
            int n = A.length;
            int[] asum = new int[n + 1];
            int[] maxl = new int[n + 1];
            int[] maxm = new int[n + 1];
            int[] msum = new int[n + 1];
            Arrays.fill(asum, 0);
            Arrays.fill(maxl, 0);
            Arrays.fill(maxm, 0);
            Arrays.fill(msum, 0);
            for (int i = 0; i < (L + M); i++){
                if (i == 1) asum[i] = A[i - 1];
                else if (i > 1)asum[i] = asum[i - 1] + A[i - 1];
                if (i >= L) maxl[i] = Math.max(maxl[i - 1], asum[i] - asum[i - L]);
                if (i >= M) maxm[i] = Math.max(maxm[i - 1], asum[i] - asum[i - M]);
            }

            for (int i = (L + M); i <= n; i++){
                asum[i] = asum[i - 1] + A[i - 1];
                int suml = asum[i] - asum[i - L];
                int summ = asum[i] - asum[i - M];
                maxl[i] = Math.max(maxl[i - 1], suml);
                maxm[i] = Math.max(maxm[i - 1], summ);
                msum[i] = Math.max(msum[i - 1], Math.max(summ + maxl[i - M], suml + maxm[i - L]));
            }
            return msum[n];
        }
    }
}
