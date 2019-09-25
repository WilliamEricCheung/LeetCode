package tech.wec.Google;

public class RLEIterator_900 {
    class RLEIterator {

        int[] A;
        int i, ptr; // i for frequence

        public RLEIterator(int[] A) {
            this.A = A;
            i = ptr = 0;
        }

        public int next(int n) {
            while (i < A.length){
                if (ptr + n > A[i]){
                    n -= A[i] - ptr;
                    ptr = 0;
                    i += 2;
                }else{
                    ptr += n;
                    return A[i + 1];
                }
            }
            return -1;
        }
    }
}
