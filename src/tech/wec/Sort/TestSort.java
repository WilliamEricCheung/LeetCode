package tech.wec.Sort;

import java.util.Arrays;

/**
 * 选择排序、快速排序、希尔排序、堆排序不是稳定的排序算法，而冒泡排序、插入排序、归并排序和基数排序是稳定的排序算法
 */
public class TestSort {
    public static void main(String[] args){
        int[] a = new int[]{9,2,9,4,5,4,8,8,2,0};
        BubbleSort.bubbleSort(a);
        System.out.println(Arrays.toString(a));
        a = new int[]{9,2,9,4,5,4,8,8,2,0};
        HeapSort.heapSort(a);
        System.out.println(Arrays.toString(a));
        a = new int[]{9,2,9,4,5,4,8,8,2,0};
        QuickSort.quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
        a = new int[]{9,2,9,4,5,4,8,8,2,0};
        System.out.println(Arrays.toString(MergeSort.mergeSort(a)));
    }
}
