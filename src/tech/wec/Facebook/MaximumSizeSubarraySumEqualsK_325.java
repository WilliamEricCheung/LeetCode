package tech.wec.Facebook;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK_325 {
    // using map
    public int maxSubArrayLen(int[] nums, int k) {
        // key = sum from 0 to i, value = i
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (!map.containsKey(sum))
                map.put(sum, i);
            int tmp = sum - k;
            if (map.containsKey(tmp))
                res = Math.max(res, i - map.get(tmp));
        }
        return res;
    }
}
