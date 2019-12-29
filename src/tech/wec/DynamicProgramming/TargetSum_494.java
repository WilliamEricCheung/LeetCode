package tech.wec.DynamicProgramming;

import java.util.Arrays;

public class TargetSum_494 {
    class Solution {
        // 2 * sum(positive) == sum(nums) + S
        // dp[]
        public int findTargetSumWays(int[] nums, int S) {
            int target = S;
            int sum = 0;
            for (int num: nums) sum += num;
            if (sum < S) return 0;
            if ((S+sum) % 2 == 1) return 0;
            target = (target + sum)/2;
            int[] dp = new int[target + 1];
            Arrays.fill(dp, 0);
            dp[0] = 1;
            for (int i = 0; i < nums.length; i++){
                for (int j = target; j >= nums[i]; j--){
                    dp[j] += dp[j - nums[i]];
                }
            }
            return dp[target];
        }
    }
}
