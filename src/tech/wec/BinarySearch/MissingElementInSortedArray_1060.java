package tech.wec.BinarySearch;

public class MissingElementInSortedArray_1060 {
    class Solution {
        public int missingElement(int[] nums, int k) {
            int n = nums.length;
            if (k > missing(n-1, nums)) // out of array
                return nums[n-1] + k - missing(n-1, nums);
            int idx = 1;
            while(missing(idx, nums) < k) idx++;
            return nums[idx - 1] + k - missing(idx - 1, nums);
        }

        // return how many missing numbers before index
        private int missing(int idx, int[] nums){
            return nums[idx] - nums[0] - idx;
        }
    }
}
