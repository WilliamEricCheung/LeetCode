package tech.wec.Array;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int closest = nums[0]+nums[1]+nums[len-1];
        int distance = Math.abs(target-closest);

        for (int i =0;i<len-2;i++){
            int left = i + 1;
            int right = len - 1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                int currentDistance = Math.abs(target-sum);
                if (distance>currentDistance){
                    distance = currentDistance;
                    closest = sum;
                }
                if (sum<target){
                    left++;
                }
                else if (sum>target){
                    right--;
                }
                else if (sum==target){
                    return sum;
                }
            }
        }
        return closest;
    }
}
