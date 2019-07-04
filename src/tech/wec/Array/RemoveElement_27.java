package tech.wec.Array;

public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i=0;i<nums.length;i++){
            if (val!=nums[i]){
                nums[len++]=nums[i];
            }
        }
        return len;
    }
}
