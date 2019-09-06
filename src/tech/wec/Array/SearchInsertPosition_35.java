package tech.wec.Array;

public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int loc = 0;
        for (int i=0;i<nums.length;i++){
            if (target>nums[i])
                loc++;
            else
                break;
        }
        return loc;
    }

    public int searchInsert_1(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        while(low <= high){
           int mid = (low + high) / 2;
           if (nums[mid] == target)
               return mid;
           else if(nums[mid] > target)
               high = mid - 1;
           else
               low = mid + 1;
        }
        return low;
    }
}
