package tech.wec.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[candidates.length];
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, result, new ArrayList<>(), visited);
        return result;
    }

    public void backtrack(int[] candidates, int target, int index,List<List<Integer>> result, List<Integer> subList, int[] visited){
        if (target == 0){
            result.add(new ArrayList<>(subList));
            return;
        }
        for (int i = index; i < candidates.length && target >= candidates[i]; i++){
            if (visited[i] == 1 || (i > index && visited[i-1] == 0 && candidates[i-1] == candidates[i]))
                continue;
            visited[i] = 1;
            subList.add(0, candidates[i]);
            backtrack(candidates, target-candidates[i], i, result, subList, visited);
            visited[i] = 0;
            subList.remove(0);
        }
    }
}
