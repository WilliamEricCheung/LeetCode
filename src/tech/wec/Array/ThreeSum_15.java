package tech.wec.Array;

import java.util.*;

public class ThreeSum_15 {
    // Brute Force
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i=0;i<nums.length-2;i++){
            int a = nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j =i+1;j<nums.length;j++){
                int res = -a - nums[j];
                if (map.containsKey(res)) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(res);
                    Collections.sort(item);
                    resultSet.add(item);
                }
                map.put(nums[j], j);
            }
        }
        return new ArrayList<>(resultSet);
    }
}
