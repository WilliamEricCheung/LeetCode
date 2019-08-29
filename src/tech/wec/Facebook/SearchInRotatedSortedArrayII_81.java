package tech.wec.Facebook;

public class SearchInRotatedSortedArrayII_81 {
    // go directly O(n)
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        for (int num: nums)
            if (num == target)
                return true;
        return false;
    }

    // binary search O(log n)
    public boolean search_1(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;
            else{
                if (nums[mid] > nums[left]){
                    if (target < nums[left] || target > nums[mid]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                } else if (nums[mid] < nums[left]){
                    if (target < nums[left] && target > nums[mid]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                } else{
                    left++;
                }
            }
        }
        return false;
    }
}
