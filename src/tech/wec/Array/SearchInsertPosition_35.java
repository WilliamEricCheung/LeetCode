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
}
