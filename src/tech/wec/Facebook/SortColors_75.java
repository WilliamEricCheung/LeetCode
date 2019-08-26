package tech.wec.Facebook;

public class SortColors_75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int zero = 0;
        while(left <= right){
            if (nums[left] == 0){
                int temp = nums[zero];
                nums[zero] = 0;
                nums[left] = temp;
                left++;
                zero++;
            } else if (nums[left] == 2){
                nums[left] = nums[right];
                nums[right--] = 2;
            } else {
                left++;
            }
        }
    }
}
