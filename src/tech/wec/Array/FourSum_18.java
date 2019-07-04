package tech.wec.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i=0;i<nums.length-3;i++){
            // remove duplicate
            if (i>0&&nums[i]==nums[i-1])
                continue;
            // current num is too small
            if (nums[i]+3*nums[nums.length-1] < target)
                continue;
            // current num is too large
            if (nums[i] * 4 > target)
                break;
            for(int j =i+1;j<nums.length-2;j++){
                if (j>i+1&&nums[j]==nums[j-1])
                    continue;
                if (nums[i]+nums[j]+2*nums[nums.length-1]<target)
                    continue;
                if (nums[i]+ nums[j]*3 > target)
                    break;
                int left = j+1,right = nums.length-1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum > target)
                        right--;
                    else if(sum <target)
                        left++;
                    else if (sum==target){
                        if (left == j+1||nums[left]!=nums[left-1]){
                            List<Integer> item = new ArrayList<Integer>();
                            item.add(nums[i]);
                            item.add(nums[j]);
                            item.add(nums[left]);
                            item.add(nums[right]);
                            result.add(item);
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
