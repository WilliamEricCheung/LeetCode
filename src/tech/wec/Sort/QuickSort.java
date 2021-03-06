package tech.wec.Sort;

import java.util.Arrays;

public class QuickSort {
    /**
     * 快速排序（递归）
     *
     * ①. 从数列中挑出一个元素，称为"基准"（pivot）。
     * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * ③. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param a   待排序数组
     * @param low   左边界
     * @param high  右边界
     */
    public static void quickSort(int[] a, int low, int high){
        if (a.length <= 0 || low >= high)
            return;
        int left = low, right = high;
        int pivot = a[left];
        while (left < right){
            while(left < right && a[right] >= pivot){
                right--;
            }
            a[left] = a[right];
            while(left < right && a[left] <= pivot){
                left++;
            }
            a[right] = a[left];
            System.out.println(Arrays.toString(a));
        }
        System.out.println("-----------------------");
        a[left] = pivot;
        quickSort(a, low, left - 1);
        quickSort(a,left + 1, high);
    }

    public static void main(String[] args) {
        int[] a = new int[]{13, 19, 9, 5, 12, 8, 7, 4, 11, 2, 6, 21};
        quickSort(a, 0, a.length - 1);
    }
}
