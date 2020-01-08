package tech.wec.BinarySearch;

public class FindMinimumInRotatedSortedArray_153 {
    class Solution {
        public int findMin(int[] nums) {
            if (nums.length == 0) return -1;
            if (nums.length == 1) return nums[0];
            int left = 0, right = nums.length - 1;
            if (nums[right] > nums[0]) return nums[0];
            while(left <= right){
                int mid = (left + right) / 2;
                if (nums[mid] > nums[mid + 1]) // 旋转点
                    return nums[mid + 1];
                if (nums[mid - 1] > nums[mid]) // 旋转点
                    return nums[mid];
                if (nums[mid] > nums[0]) // 前一半是按顺序存的
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            return -1;
        }
    }
}
