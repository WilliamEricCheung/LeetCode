package tech.wec.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else {
                j++;
            }
        }
        int ret[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ret[i] = res.get(i);
        return ret;
    }
}
