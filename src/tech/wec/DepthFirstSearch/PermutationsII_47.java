package tech.wec.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        backtrack(result, nums, visited, new ArrayList<Integer>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int[] visited, ArrayList<Integer> candidate){
        if (candidate.size()==nums.length){
            result.add(new ArrayList<>(candidate));
            return;
        }
        for (int i =0;i<nums.length;i++){
            if (visited[i] == 1 || (i > 0 && visited[i-1] == 0 && nums[i] == nums[i-1])) continue;
            visited[i] = 1;
            candidate.add(nums[i]);
            backtrack(result, nums, visited, candidate);
            visited[i] = 0;
            candidate.remove(candidate.size() - 1);
        }
    }
}
