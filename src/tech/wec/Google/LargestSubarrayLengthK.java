package tech.wec.Google;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LargestSubarrayLengthK {

    public static void main(String[] args) {

    }

    // sliding window
    // O((N-K)*K)
    static Integer[] largestSubarray(Integer[] N, int K) {
        if (K <= 0) // if subarray length <= 0, return a empty array
            return new Integer[]{};
        if (N.length <= 0 || K >= N.length )
            return N; // if N is empty or subarray's length >= N, return N itself
        int idx = 0; // the index for the subarray
        for (int i = 1; i < N.length - K + 1; i++){
            for (int ptr = 0; ptr < K; ptr++){ // the pointer for the subarray to compare
                if (N[idx + ptr] < N[i + ptr]){  // if currrent Integer is larger
                    idx = i;                   // save the larger one
                    break;
                }else if (N[idx + ptr] > N[i + ptr])
                    break;
            }
        }
        return Arrays.copyOfRange(N, idx, idx + K);
    }
}