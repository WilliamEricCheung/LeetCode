package tech.wec.Array;

public class MaximumSubarray_53 {

    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

    }

    // use iterate with its sequence
    public int maxSubArray_1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int best = 0;
        for (int i = 0; i < nums.length; i++) {
            best += nums[i];
            if (best > max)
                max = best;
            if (best < 0)
                best = 0;
        }
        return max;
    }

    // use divide and conquer method to implement it
    public int maxSubArray_2(int[] nums) {
        if (nums.length == 0)
            return 0;
        return devideAndConquer(nums, 0, nums.length - 1);
    }

    public int devideAndConquer(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        int center, left_sum, right_sum, s1 = Integer.MIN_VALUE, s2 = Integer.MIN_VALUE;
        int l = 0, r = 0;
        center = (left + right) / 2;
        left_sum = devideAndConquer(nums, left, center); // left;
        right_sum = devideAndConquer(nums, center + 1, right); //right

        // find max value from left
        for (int i = center; i >= left; i--) {
            l = l + nums[i];
            if (s1 < l)
                s1 = l;
        }
        // find max value from right
        for (int i = center + 1; i <= right; i++) {
            r = r + nums[i];
            if (s2 < r)
                s2 = r;
        }
        // judge
        if (left_sum > right_sum && left_sum > (s1 + s2))
            return left_sum;
        else if (right_sum > (s1 + s2))
            return right_sum;
        else
            return s1 + s2;
    }
}
