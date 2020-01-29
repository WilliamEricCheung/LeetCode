package tech.wec.iLoveZQW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            if (nums.length < 3) return ans;
            for (int i = 2; i < nums.length; i++){
                if (i < nums.length - 1 && nums[i] == nums[i + 1]) continue;
                int left = 0, right = i - 1;
                while(left < right){
                    while( left < right && nums[left] + nums[right] + nums[i] < 0) left++;
                    while( left < right && nums[left] + nums[right] + nums[i] > 0) right--;
                    if (left < right && nums[left] + nums[right] + nums[i] == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[left]); temp.add(nums[right]); temp.add(nums[i]);
                        ans.add(temp);
                        int leftValue = nums[left];
                        int rightValue = nums[right];
                        while(left < right && nums[left] == leftValue) left++;
                        while(left < right && nums[right] == rightValue) right--;
                    }
                }
            }
            return ans;
        }
    }
}
