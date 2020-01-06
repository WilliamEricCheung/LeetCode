package tech.wec.Math;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum_523 {
    class Solution {

        // calculate presum
        public boolean checkSubarraySum(int[] nums, int k) {
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            for (int i = 0; i < nums.length; i++){
                sum += nums[i];
                if (k != 0) sum = sum % k;
                if (map.containsKey(sum)) { // 如果之前出现了重复的余数就是产生了k的倍数
                    if (i - map.get(sum) > 1)
                        return true;
                }
                else map.put(sum, i);
            }
            return false;
        }
    }
}
