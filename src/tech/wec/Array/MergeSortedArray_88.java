package tech.wec.Array;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // inverse traversal
        for (int i = m + n - 1;i>=0;i--){
            int M = m-1>=0 ? nums1[m-1]:Integer.MIN_VALUE;
            int N = n-1>=0? nums2[n-1]:Integer.MIN_VALUE;
            nums1[i] = Math.max(M,N);
            if (M<N){
                n--;
            }else
                m--;
        }
    }
}
