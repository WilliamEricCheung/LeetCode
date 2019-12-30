package tech.wec.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SortAnArray_912 {
    public List<Integer> sortArray(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int num: nums) result.add(num);
        return result;
    }
}
