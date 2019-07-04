package tech.wec.Array;

public class RemoveDuplicatesFromSortedArray_26 {
    // It doesn't matter what you leave beyond the returned length.
    public int removeDuplicates(int[] nums) {
        int len = 0;
        if(nums.length==0)
            return 0;
        for(int i=1;i<nums.length;i++){
            if (nums[len]!=nums[i]){
                nums[++len]=nums[i];
            }
        }
        return len;
    }
}
