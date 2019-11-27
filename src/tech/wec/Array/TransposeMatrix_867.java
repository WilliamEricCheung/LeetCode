package tech.wec.Array;

public class TransposeMatrix_867 {
    public int[][] transpose(int[][] A) {
        int[][] ans = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }
}
