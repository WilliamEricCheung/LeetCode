package tech.wec.HashTable;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber_136 {
    // every element appears twice except for one
    // Math method
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int minus = 0;
        for(int num: nums){
            set.add(num);
            minus += num;
        }
        int sum = 0;
        for (int num: set){
            sum += num;
        }
        return 2 * sum - minus;
    }
}
