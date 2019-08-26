package tech.wec.Facebook;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    // recursive
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        subsetsHelper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void subsetsHelper(int[] nums, int i, List<Integer> current, List<List<Integer>> result ){
        if (i == nums.length){
            result.add(current);
            return;
        }
        List<Integer> path = new ArrayList<>(current);
        path.add(nums[i]);

        subsetsHelper(nums, i + 1, path, result);
        subsetsHelper(nums, i + 1, current, result);
    }

    // bit manipulation
    public List<List<Integer>> subsets_1(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int total = 1 << nums.length;
        for (int i = 0;i<total;i++){
            List<Integer> temp = new ArrayList<>();
            getSubsets(nums, i, temp);
            result.add(temp);
        }
        return result;
    }

    private void getSubsets(int[] nums, int i, List<Integer> temp){
        int index = 0;
        for (int p = i; p > 0; p >>= 1){
            if ((p & 1) == 1)
                temp.add(nums[index]);
            index++;
        }
    }

}
