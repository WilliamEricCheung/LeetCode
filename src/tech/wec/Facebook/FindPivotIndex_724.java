package tech.wec.Facebook;

import java.util.Arrays;

public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int n:nums)
            sum += n;
        int left = 0;
        for (int i =0;i<nums.length;i++){
            if (left == sum - left - nums[i])
                return i;
            left += nums[i];
        }
        return -1;
    }
}
