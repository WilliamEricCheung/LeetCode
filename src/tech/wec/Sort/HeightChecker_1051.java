package tech.wec.Sort;

import java.util.Arrays;

public class HeightChecker_1051 {
    public int heightChecker(int[] heights) {
        int[] old = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int ans = 0;
        for (int i = 0; i < old.length; i++){
            if (old[i] != heights[i])
                ans++;
        }
        return ans;
    }
}
