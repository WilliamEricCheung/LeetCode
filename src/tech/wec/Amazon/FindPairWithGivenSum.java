package tech.wec.Amazon;

import java.util.HashMap;
import java.util.Map;

public class FindPairWithGivenSum {

    // 和 two sum一回事
    public int[] findPair(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                if (nums[i] > max || nums[map.get(nums[i])] > max){
                    result[0] = map.get(nums[i]);
                    result[1] = i;
                    max = Math.max(nums[i], nums[map.get(nums[i])]);
                }
            }
            map.put(target - nums[i], i);
        }
        return result;
    }
}
