package tech.wec.Sort;

import java.util.Arrays;

public class MergeSort {
    /**
     * 归并排序（递归）
     *
     * ①. 将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
     * ②. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
     * ③. 重复步骤②，直到所有元素排序完毕。
     * @param a	 待排序数组
     */
    public static int[] mergeSort(int[] a){
        if (a.length <= 1) return a;
        int mid = a.length >> 1;
        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);
        return mergeTwoArray(mergeSort(left), mergeSort(right));
    }

    private static int[] mergeTwoArray(int[] a1, int[] a2){
        int p = 0, q = 0, ptr = 0;
        int[] res = new int[a1.length + a2.length];
        while(p<a1.length && q<a2.length){
            if (a1[p] <= a2[q])
                res[ptr++] = a1[p++];
            else
                res[ptr++] = a2[q++];
        }
        while(p<a1.length)
            res[ptr++] = a1[p++];
        while(q<a2.length)
            res[ptr++] = a2[q++];
        return res;
    }
}
