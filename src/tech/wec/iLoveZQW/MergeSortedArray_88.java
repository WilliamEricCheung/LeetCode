package tech.wec.iLoveZQW;

public class MergeSortedArray_88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = m + n - 1; i >= 0; i--){
                int num1 = m - 1 >= 0? nums1[m - 1] : Integer.MIN_VALUE;
                int num2 = n - 1 >= 0? nums2[n - 1] : Integer.MIN_VALUE;
                nums1[i] = Math.max(num1, num2);
                if (num1 > num2) m--;
                else n--;
            }
        }
    }
}
