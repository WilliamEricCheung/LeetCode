package tech.wec.Math;

public class PaintFence_276 {
    class Solution {
        public int numWays(int n, int k) {
            if (n == 0 || k == 0 || k == 1 && n > 2) return 0;
            if (n == 1) return k;
            int p = k * (k - 1);
            int result = p + k;
            for (int i = 3; i <= n; i++){
                result = result * (k - 1) + p;
                p = result - p;
            }
            return result;
        }
    }

    class Solution_1 {
        public int numWays(int n, int k) {

		/*
        dp[i][0] -> ith fence has same color with (i-1)th fence
        dp[i][1] -> ith fence has different color with (i-1)th fence

        if ith fence has the same color with (i-1)th, it also means that i-1 must has different color with i - 2.
		If i-1 is the same as i-2, there will be i, i-1, i-2 in the same color and that's wrong.
		So we can come up with following expression.
        dp[i][0] = dp[i-1][1]

        if ith fence has different color with (i-1)th, so that i - 1 can be the same color with i - 2, or has different color with i - 2
        which means ith fence has chosen 1 color from k colors, then i-1 can choose the rest k-1 types of color, the same as i - 2
        dp[i][1] = dp[i-1][0]*(k-1) + dp[i-1][1]*(k-1)

        if we create dp[n][2], in order to avoid index out of bound error, i needs to start from 1 so that i-1 >= 0,
		and finally we can return the sum of dp[n-1][0] and dp[n-1][1]
		*/

            //base case
            if(n <= 0) return 0;
            if(n == 1) return k;

            int[][] dp = new int[n][2];
            //we need to include the base case
            dp[0][0] = 0;
            dp[0][1] = k;

            for(int i = 1; i < n; i++){
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0]*(k-1) + dp[i-1][1]*(k-1);
            }

            return dp[n-1][0] + dp[n-1][1];

        }
    }
}
