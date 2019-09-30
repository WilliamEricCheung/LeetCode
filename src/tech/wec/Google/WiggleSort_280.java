package tech.wec.Google;

public class WiggleSort_280 {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0 && !(nums[i] < nums[i + 1]))
                swap(nums, i, i + 1);
            if (i % 2 == 1 && !(nums[i] > nums[i + 1]))
                swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
