package tech.wec.DynamicProgramming;

public class PartitionEqualSubsetSum_416 {
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums.length == 0) return false;
            int sum = 0;
            for (int num: nums) sum += num;
            if (sum % 2 != 0) return false;
            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            if (nums[0] <= target) dp[nums[0]] = true;
            for (int i = 1; i < nums.length; i++){
                boolean[] next = new boolean[target + 1];
                for (int j = 0; j <= target; j++){
                    next[j] = dp[j];
                    if (j >= nums[i] && dp[j - nums[i]]) next[j] = true;
                }
                dp = next;
            }
            return  dp[target];
        }
    }
}
