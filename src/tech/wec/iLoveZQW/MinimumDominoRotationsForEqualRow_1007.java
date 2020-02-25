package tech.wec.iLoveZQW;

public class MinimumDominoRotationsForEqualRow_1007 {
    class Solution {
        public int minDominoRotations(int[] A, int[] B) {
            if(A.length != B.length) return -1;
            int rot = rotate(A, B, A[0]);
            if (rot != -1 || A[0] == B[0]) return rot;
            else return rotate(A, B, B[0]);
        }

        private int rotate(int[] A, int[] B, int x){
            int len = A.length;
            int rotA = 0, rotB = 0;
            for (int i = 0; i < len; i++){
                if (A[i] != x && B[i] != x) return -1;
                else if (A[i] != x) rotA++;
                else if (B[i] != x) rotB++;
            }
            return Math.min(rotA, rotB);
        }
    }
}
