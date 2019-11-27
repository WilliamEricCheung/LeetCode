package tech.wec.BinarySearch;

import java.util.Arrays;

public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
            while(sum >= s){
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE)? ans : 0;
    }

}
