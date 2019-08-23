package tech.wec.Math;

public class MinimumMovesToEqualArrayElements_453 {

    public int minMoves(int[] nums) {
        int min = nums[0], ans = 0;
        for (int n: nums)
            min = Math.min(min, n);
        for (int n: nums)
            ans += n - min;
        return ans;
    }
}
