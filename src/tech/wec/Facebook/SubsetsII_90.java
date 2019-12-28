package tech.wec.Facebook;

import java.util.*;

public class SubsetsII_90 {
    // bit manipulation
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int total = 1 << nums.length;
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < total; i++){
            PriorityQueue<Integer> temp = new PriorityQueue<>();
            getSubsets(nums, i, temp);
            result.add(new ArrayList<>(temp));
        }
        return new ArrayList<>(result);
    }

    private void getSubsets(int[] nums, int i, PriorityQueue<Integer> temp){
        int index = 0;
        for (int k = i; k > 0; k >>= 1){
            if ((k & 1) == 1) temp.add(nums[index]);
            index++;
        }
    }
}
