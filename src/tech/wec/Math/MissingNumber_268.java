package tech.wec.Math;

public class MissingNumber_268 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum = n * (n + 1) / 2;
        long numSum = 0;
        for (int i : nums
        ) {
            numSum += i;
        }
        return (int) (sum - numSum);
    }
}
