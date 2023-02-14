package tech.wec.Facebook;

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int len = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[len++] = nums[i];
            }
        }
        for(int i = len; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
