package tech.wec.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference_1218 {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1);
            if (dp.containsKey(arr[i] - difference)) dp.put(arr[i], dp.get(arr[i] - difference) + 1);
        }
        int max = 0;
        for (int value : dp.values()) {
            max = Math.max(max, value);
        }
        return max;
    }
}
