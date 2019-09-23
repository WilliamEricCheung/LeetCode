package tech.wec.Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] a){
        int len = a.length;
        for (int i = len; i > 0; i--){
            for (int j = 0; j < len - 1; j++){
                if (a[j] > a[j + 1]){
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }
}
