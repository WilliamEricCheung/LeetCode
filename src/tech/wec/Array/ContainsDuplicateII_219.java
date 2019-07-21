package tech.wec.Array;

import java.util.*;

public class ContainsDuplicateII_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || k < 0)return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i< nums.length; i++){
            if(map.containsKey(nums[i]) && (k >= Math.abs(map.get(nums[i]) - i))){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
