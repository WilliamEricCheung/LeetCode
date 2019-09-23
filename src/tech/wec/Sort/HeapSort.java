package tech.wec.Sort;

import java.util.Arrays;

public class HeapSort {
    /**
     * 堆排序
     *
     * 1. 先将初始序列K[1..n]建成一个大顶堆, 那么此时第一个元素K1最大, 此堆为初始的无序区.
     * 2. 再将关键字最大的记录K1 (即堆顶, 第一个元素)和无序区的最后一个记录 Kn 交换, 由此得到新的无序区K[1..n−1]和有序区K[n], 且满足K[1..n−1].keys⩽K[n].key
     * 3. 交换K1 和 Kn 后, 堆顶可能违反堆性质, 因此需将K[1..n−1]调整为堆. 然后重复步骤②, 直到无序区只有一个元素时停止.
     * @param a 待排序数组
     */
    public static void heapSort(int[] a){
        for (int i = a.length; i > 0; i--){
            maxHeapify(a, i);
            int tmp = a[0]; // 堆顶元素（第一个元素）与Kn交换
            a[0] = a[i - 1];
            a[i - 1] = tmp;
        }
    }

    private static void maxHeapify(int[] a, int limit){
        if (a.length <= 0 || a.length < limit)
            return;
        for (int parentIdx = limit / 2; parentIdx >= 0; parentIdx--){
            if (parentIdx * 2 >= limit)
                continue;
            int left = parentIdx * 2; // 左子节点位置
            int right = (left + 1) >= limit ? left : (left + 1); // 右子节点位置，如果没有右节点，默认为左节点位置
            int maxChildId = a[left] >= a[right] ? left : right;
            if (a[maxChildId] > a[parentIdx]){
                // 交换父节点与左右子节点中的最大值
                int tmp = a[parentIdx];
                a[parentIdx] = a[maxChildId];
                a[maxChildId] = tmp;
            }
        }
    }

    /*
从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。一是建堆函数，二是反复调用建堆函数以选择出剩余未排元素中最大的数来实现排序的函数。

总结起来就是定义了以下几种操作：

最大堆调整（Max_Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
创建最大堆（Build_Max_Heap）：将堆所有数据重新排序
堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
对于堆节点的访问：

父节点i的左子节点在位置：(2*i+1);
父节点i的右子节点在位置：(2*i+2);
子节点i的父节点在位置：floor((i-1)/2);
     */
}
