package tech.wec.Array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    // Brute Force
    public int[] twoSum(int[] nums, int target) {
        for(int i =0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    // HashMap
    public int[] twoSum1(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int find = target - nums[i];
            if (map.containsKey(find)){
                return new int[]{map.get(find), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
