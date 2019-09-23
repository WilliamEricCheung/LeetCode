package tech.wec.Google;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long prev = (long)lower - 1;
        for (int i =0;i<=nums.length;i++){
            long t = i == nums.length ? (long)upper + 1 : nums[i];
            if (t == prev + 2)
                result.add(String.valueOf(prev + 1));
            else if (t > prev + 2)
                result.add((prev + 1) + "->" + (t-1));
            prev = t;
        }
        return result;
    }
}
