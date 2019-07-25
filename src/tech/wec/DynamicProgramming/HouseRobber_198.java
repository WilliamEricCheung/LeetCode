package tech.wec.DynamicProgramming;

public class HouseRobber_198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int tmp = nums[0];
        for (int i = 2;i< nums.length;i++){
            dp[i] = Math.max(tmp + nums[i], dp[i-1]);// 取i-1前(不包括i)的最大和+当前数与前一次比较
            tmp = Math.max(tmp, dp[i-1]); // 更新取i-1前（不包括i）的最大和
        }
        return dp[nums.length - 1];
    }
}
