package tech.wec.DynamicProgramming;

public class RangeSumQuery_303 {

    // Range[i, j] = sum[j+1] - sum[i]
    private int[] sum;

    public RangeSumQuery_303(int[] nums) {
        sum = new int[nums.length+1];
        //sum[0] = nums[0];
        for (int i =0;i<nums.length;i++){
            sum[i+1] = sum[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}
