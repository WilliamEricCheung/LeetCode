package tech.wec.Google;

// Magic Square
public class FillMatrix {

    //Backtracking Algorithm
    int[][] fillMatrix(int n) {
        boolean[] picked = new boolean[n * n + 1];
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = -1;
            }
        }
        boolean found = fillMatrixHelper(n, mat, picked, 0, 0);
        if (found) {
            return mat;
        } else {
            return null;
        }
    }

    public boolean fillMatrixHelper(int n, int[][] mat, boolean[] picked, int ri, int ci) {
        if (ci == n) {
            ci = 0;
            ri++;
        }
        if (ri == n) {
            boolean check = checkIfValid(n, mat);
            return check;
        }
        for (int i = 1; i <= n * n; i++) {
            if (!picked[i]) {
                picked[i] = true;
                mat[ri][ci] = i;
                boolean check = fillMatrixHelper(n, mat, picked, ri, ci + 1);
                if (check) {
                    return true;
                }
                mat[ri][ci] = -1;
                picked[i] = false;
            }
        }
        return false;
    }

    public boolean checkIfValid(int n, int[][] mat) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                temp += mat[i][j];
            }
            if (temp != sum) {
                return false;
            }
        }
        for (int j = 0; j < n; j++) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp += mat[i][j];
            }
            if (temp != sum) {
                return false;
            }
        }
        int temp;
        temp = 0;
        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            temp += mat[i][j];
        }
        if (temp != sum) {
            return false;
        }
        temp = 0;
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            temp += mat[i][j];
        }
        if (temp != sum) {
            return false;
        }
        return true;
    }
}

