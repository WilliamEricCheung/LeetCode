package tech.wec.Facebook;

public class MonotonicArray_896 {
    public boolean isMonotonic(int[] A) {
        boolean increase = true;
        boolean decrease = true;
        for (int i =0;i<A.length-1;i++){
            if (A[i] < A[i+1])
                decrease = false;
            if (A[i] > A[i+1])
                increase = false;
        }
        return increase || decrease;
    }
}
