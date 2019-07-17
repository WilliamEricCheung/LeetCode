package tech.wec.DivideAndConquer;

import java.util.Arrays;

public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
