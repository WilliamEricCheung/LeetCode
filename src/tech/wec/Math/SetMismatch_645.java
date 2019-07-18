package tech.wec.Math;

public class SetMismatch_645 {
    public int[] findErrorNums(int[] nums) {
        int dup = -1;
        int loss = 1;
        for (int n:nums){
            if (nums[Math.abs(n) - 1] < 0)
                dup = Math.abs(n);
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        for (int i=1;i<nums.length;i++)
            if (nums[i]>0)
                loss = i + 1;
        return new int[]{dup, loss};
    }
}
