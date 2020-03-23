package tech.wec.iLoveZQW;

public class NextPermutation_31 {
    class Solution {
        public void nextPermutation(int[] nums) {
            int pivot = nums.length - 2;
            while(pivot >= 0 && nums[pivot] >= nums[pivot + 1])
                pivot--;
            if (pivot >= 0) {
                int ptr = 0;
                for (int i = nums.length - 1; i > pivot; i--) {
                    if (nums[i] > nums[pivot]) {
                        ptr = i;
                        break;
                    }
                }
                int temp = nums[pivot];
                nums[pivot] = nums[ptr];
                nums[ptr] = temp;
            }
            int left = pivot + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
}
