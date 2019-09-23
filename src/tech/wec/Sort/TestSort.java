package tech.wec.Sort;

import java.util.Arrays;

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
