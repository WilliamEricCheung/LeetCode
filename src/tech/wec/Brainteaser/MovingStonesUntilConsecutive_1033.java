package tech.wec.Brainteaser;

import java.util.Arrays;

public class MovingStonesUntilConsecutive_1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] nums = new int[]{a, b, c};
        Arrays.sort(nums);
        int x = nums[0], y = nums[1], z = nums[2];
        int min;
        if (z - y == 2 || y - x == 2)
            min = 1;
        else
            min = (z - y == 1 ? 0 : 1) + (y - x == 1 ? 0 : 1);
        int max = z - x > 2 ? z - x - 2 : 0;
        return new int[]{min, max};
    }
}
