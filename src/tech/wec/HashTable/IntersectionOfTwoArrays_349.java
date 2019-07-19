package tech.wec.HashTable;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1
        ) {
            set1.add(num);
        }
        for (int num : nums2
        ) {
            set2.add(num);
        }
        set1.retainAll(set2);
        Object[] res = set1.toArray();
        int[] ress = new int[res.length];
        for (int i = 0; i < res.length; i++)
            ress[i] = (int) res[i];
        return ress;
    }
}
