package tech.wec.Google;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LargestSubarrayLengthK {

    public static void main(String[] args){
        int[] a = new int[]{9,2,9,4,5,4,8,8,2,0};
        System.out.println(Arrays.toString(largestSubarray(a, 4)));
    }

    // sliding window
    public static int[] largestSubarray(int[] a, int k){
        int idx = 0;
        for (int i = 1; i < a.length - k + 1; i++){
            for (int ptr = 0; ptr < k; ptr++){
                if (a[idx + ptr] < a[i + ptr]){
                    idx = i;
                    break;
                }else if (a[idx + ptr] > a[i + ptr])
                    break;
            }
        }
        return Arrays.copyOfRange(a, idx, idx + k);
    }
}
