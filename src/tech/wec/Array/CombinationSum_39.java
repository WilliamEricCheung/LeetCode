package tech.wec.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target,0,new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> subList){
        if (target == 0){
            result.add(new ArrayList<>(subList));
            return;
        }

        for (int i= index; i<candidates.length && target>=candidates[i];i++){
            subList.add(0, candidates[i]);
            helper(candidates, target-candidates[i],i,subList);
            subList.remove(0);
        }
    }
}
