package tech.wec.Amazon;

import java.util.Arrays;

public class TwoSumLessThanK_1099 {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int start = 0;
        int end = A.length - 1;
        int max = 0;
        while(start < end){
            int sum = A[start] + A[end];
            if (sum >= K)
                end--;
            else{
                max = Math.max(sum, max);
                start++;
            }
        }
        return max == 0? -1 : max;
    }
}
