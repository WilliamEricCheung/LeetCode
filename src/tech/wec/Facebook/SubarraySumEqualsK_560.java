package tech.wec.Facebook;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        // key for sum, value for index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum - k)){
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
