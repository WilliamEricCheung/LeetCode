package tech.wec.DynamicProgramming;

public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        int res = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < 0){
                int tmp = min;
                min = max;
                max = tmp;
            }
            max *= nums[i];
            if (max < nums[i])
                max = nums[i];
            min *= nums[i];
            if (min > nums[i])
                min = nums[i];
            if (max > res)
                res = max;
        }
        return res;
    }
}
