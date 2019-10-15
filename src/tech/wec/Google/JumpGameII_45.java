package tech.wec.Google;

public class JumpGameII_45 {
    public int jump(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        int lastPos = 0;
        for (int i = 0; i < len; i++){
            for (int j = lastPos - i + 1; (i + j) < len && j <= nums[i]; j++){
                if (dp[i + j] == 0 || dp[i + j] > dp[i] + 1){
                    dp[i + j] = dp[i] + 1;
                    lastPos = i + j;
                }
            }
        }
        return dp[len - 1];
    }
}
