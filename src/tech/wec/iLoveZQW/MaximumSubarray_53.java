package tech.wec.iLoveZQW;

public class MaximumSubarray_53 {

    class Solution {
        public int maxSubArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int num: nums){
                sum += num;
                if (sum > max) max = sum;
                if (sum < 0) sum = 0;
            }
            return max;
        }
    }
}
