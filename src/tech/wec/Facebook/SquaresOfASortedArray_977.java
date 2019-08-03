package tech.wec.Facebook;

public class SquaresOfASortedArray_977 {

    // very much like merge two sorted linked list
    public int[] sortedSquares(int[] A) {
        // pointer of non-negative
        int ptr = 0;
        int len = A.length;
        int[] result = new int[len];
        // split array A to <0 and >=0
        while(ptr<len&&A[ptr]<0)
            ptr++;
        // negative
        int neg = ptr - 1;
        int p = 0;
        while(neg >=0 && ptr < len){
            if (A[neg] * A[neg] < A[ptr] * A[ptr]){
                result[p++] = A[neg] * A[neg];
                neg--;
            }else{
                result[p++] = A[ptr] * A[ptr];
                ptr++;
            }
        }
        while(neg >= 0){
            result[p++] = A[neg] * A[neg];
            neg--;
        }
        while(ptr<len){
            result[p++] = A[ptr] * A[ptr];
            ptr++;
        }
        return result;
    }
}
