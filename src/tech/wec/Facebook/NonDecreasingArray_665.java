package tech.wec.Facebook;

public class NonDecreasingArray_665 {

    public boolean checkPossibility(int[] nums) {
        int flag = -1;
        for (int i =0;i<nums.length-1;i++){
            if (nums[i] > nums[i+1]){
                if(flag != -1)
                    return false;
                flag = i;
            }
        }
        return flag == -1 || flag == 0 || flag == nums.length - 2
                || nums[flag - 1]<=nums[flag + 1] || nums[flag] <= nums[flag + 2];
    }
}
