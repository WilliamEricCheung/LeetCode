package tech.wec.BinarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {
        int low = findLimit(nums, target, true);
        if (low == nums.length || nums[low] != target)
            return new int[]{-1, -1};
        int high = findLimit(nums, target, false);
        return new int[]{low, high -1};
    }


    /**
     * find the low limit or high limit of the element
     * @param nums
     * @param target
     * @param direct true represent low, false represent high
     * @return
     */
    private int findLimit(int[] nums, int target, boolean direct){
        int start = 0, end = nums.length;
        int mid = start + (end - start) / 2;;
        while(start < end) {
            if (nums[mid] > target || (direct && nums[mid] == target )) {
                end = mid;
            }else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return mid;
    }
}
