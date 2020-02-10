package tech.wec.iLoveZQW;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {

    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> presum = new HashMap<>();
            presum.put(0, 1);
            int cnt = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++){
                sum += nums[i];
                if (presum.containsKey(sum - k))
                    cnt += presum.get(sum - k);
                presum.put(sum, presum.getOrDefault(sum, 0) + 1);
            }
            return cnt;
        }
    }
}
