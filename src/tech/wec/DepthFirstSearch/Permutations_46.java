package tech.wec.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<Integer> added, int[] nums){
        if (added.size() == nums.length){
            result.add(new ArrayList<>(added));
            return;
        }
        for (int i =0;i<nums.length;i++){
            if (!added.contains(nums[i])){
                added.add(nums[i]);
                backtrack(added, nums);
                added.remove(added.size()- 1);
            }
        }
    }
}
