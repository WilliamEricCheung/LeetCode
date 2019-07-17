package tech.wec.DivideAndConquer;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int i = 0;
        int j = nums1.length;
        while (i <= j) {
            int splitNums1 = (i + j) / 2;
            int splitNums2 = (nums1.length + nums2.length + 1) / 2 - splitNums1;

            int maxLeftNums1, maxLeftNums2, minRightNums1, minRightNums2;
            if (splitNums1 == 0)
                maxLeftNums1 = Integer.MIN_VALUE;
            else
                maxLeftNums1 = nums1[splitNums1 - 1];

            if (splitNums2 == 0)
                maxLeftNums2 = Integer.MIN_VALUE;
            else
                maxLeftNums2 = nums2[splitNums2 - 1];

            if (splitNums1 == nums1.length)
                minRightNums1 = Integer.MAX_VALUE;
            else
                minRightNums1 = nums1[splitNums1];

            if (splitNums2 == nums2.length)
                minRightNums2 = Integer.MAX_VALUE;
            else
                minRightNums2 = nums2[splitNums2];

            if (maxLeftNums1 <= minRightNums2 && minRightNums1 >= maxLeftNums2){
                if ((nums1.length + nums2.length) % 2 == 0)
                    return (double)(1.0 * Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2))/2;
                else
                    return (double)(Math.max(maxLeftNums1, maxLeftNums2));
            }else if (maxLeftNums1 > minRightNums2)
                j = splitNums1 - 1;
            else
                i = splitNums1 + 1;
        }
        return 0.0;
    }
}
