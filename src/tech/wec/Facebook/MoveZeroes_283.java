package tech.wec.Facebook;

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int cntZero = 0;
        int loc = 0;
        for (int i =0;i<nums.length;i++){
            if (nums[i] == 0){
                cntZero++;
            }else{
                nums[loc++] = nums[i];
            }
        }
        for (int i=nums.length-1, j = cntZero;j>0;j--){
            nums[i--] = 0;
        }
    }
}
