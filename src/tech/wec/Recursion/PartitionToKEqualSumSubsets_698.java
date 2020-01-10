package tech.wec.Recursion;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets_698 {
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = Arrays.stream(nums).sum();
            if (sum % k > 0) return false;
            int target = sum / k;
            Arrays.sort(nums);
            int index = nums.length - 1;
            if (nums[index] > target) return false;
            while(index >= 0 && nums[index] == target){
                index--;
                k--;
            }
            return search(new int[k], index, nums, target);
        }

        public boolean search(int[] groups, int index, int[] nums, int target){
            if (index < 0) return true;
            int value = nums[index--];
            for (int i = 0; i < groups.length; i++){
                if (groups[i] + value <= target){
                    groups[i] += value;
                    if (search(groups, index, nums, target)) return true;
                    groups[i] -= value;
                }
                if (groups[i] == 0) break;
            }
            return false;
        }
    }
}
