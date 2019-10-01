package tech.wec.Google;

public class MinimumDominoRotationsForEqualRow {
    // greedy
    public int minDominoRotations(int[] A, int[] B) {
        int len = A.length;
        int rots = check(A, B, A[0], len);
        if (rots != -1 || A[0] == B[0]) return rots;
        else return check(A, B, B[0], len);
    }

    private int check(int[] A, int[] B, int x, int len){
        int rot_a = 0, rot_b = 0;
        for (int i = 0; i < len; i++){
            if (A[i] != x && B[i] != x) return -1;
            else if (A[i] != x) rot_a++;
            else if (B[i] != x)  rot_b++;
        }
        return Math.min(rot_a, rot_b);
    }
}
