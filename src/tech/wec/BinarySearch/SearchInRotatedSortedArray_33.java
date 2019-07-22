package tech.wec.BinarySearch;

public class SearchInRotatedSortedArray_33 {

    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length,target);
    }

    private int helper(int[] nums, int left, int right, int target){
        if (right <= left)
            return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;
        int leftV = helper(nums, left, mid, target);
        int rightV = helper(nums, mid+1, right, target);
        if (leftV != -1)
            return leftV;
        else if (rightV != -1)
            return rightV;
        else
            return -1;
    }
}