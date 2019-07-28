package tech.wec.Facebook;

public class LongestContinuousIncreasingSubsequence_674 {

    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, ptr = 0;
        for (int i =0;i<nums.length;i++){
            if (i>0 && nums[i-1]>=nums[i])
                ptr = i;
            ans = Math.max(ans, i - ptr + 1);
        }
        return ans;
    }
}
