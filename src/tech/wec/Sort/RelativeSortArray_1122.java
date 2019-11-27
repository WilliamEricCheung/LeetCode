package tech.wec.Sort;

import java.util.*;

public class RelativeSortArray_1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int idx = 0;
        for (int i = 0; i < arr2.length; i++){
            int match = arr2[i];
            int ptr = idx;
            while(ptr < arr1.length){
                if (match == arr1[ptr]){
                    int tmp = arr1[idx];
                    arr1[idx] = arr1[ptr];
                    arr1[ptr] = tmp;
                    if (ptr == idx)
                        ptr++;
                    idx++;
                }else
                    ptr++;
            }
        }

        if (idx < arr1.length - 1)
            Arrays.sort(arr1, idx, arr1.length);
        return arr1;
    }
}
