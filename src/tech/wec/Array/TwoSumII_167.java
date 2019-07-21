package tech.wec.Array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII_167 {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<numbers.length;i++){
            int find = target - numbers[i];
            if (map.containsKey(find)){
                return new int[]{map.get(find)+1, i+1};
            }
            map.put(numbers[i],i);
        }
        return null;
    }

    public int[] twoSum_1(int[] nums, int target){
        int l = 0, h = nums.length - 1;
        while(nums[l] + nums[h] != target){
            if(nums[l] + nums[h] > target) h--;
            else if(nums[l] + nums[h] < target) l++;
        }
        return new int[] {l+1, h+1};
    }
}
