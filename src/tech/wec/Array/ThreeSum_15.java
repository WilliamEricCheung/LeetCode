package tech.wec.Array;

import java.util.*;

public class ThreeSum_15 {
    // Brute Force
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        int len = nums.length;
        if (len < 3)
            return new ArrayList<>(resultSet);
        for (int i=0;i<len-2;i++){
            int a = nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j =i+1;j<len;j++){
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

    public List<List<Integer>> threeSum_1(int[] nums){
        Set<List<Integer>> resultSet = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3)
            return new ArrayList<>(resultSet);
        for (int i = 2; i < len; i++){
            if (i < len - 1 && nums[i] == nums[i+1])
                continue;
            int left = 0, right = i - 1;
            while(left < right){
                while(left < right && nums[left] + nums[right] > - nums[i])
                    right--;
                while(left < right && nums[left] + nums[right] < - nums[i])
                    left++;
                if (left < right && nums[left] + nums[right] + nums[i] == 0){
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[left]);
                    item.add(nums[right]);
                    item.add(nums[i]);
                    resultSet.add(item);
                    int leftValue = nums[left], rightValue = nums[right];
                    while(left < right && leftValue == nums[left]) left++;
                    while(left < right && rightValue == nums[right]) right--;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
}
