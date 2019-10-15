package tech.wec.Google;

public class SudokuSolver_37 {
    // constrained programming
    // 9 for length, 10 for 10 numbers
    int[][] rows = new int[9][10];
    int[][] cols = new int[9][10];
    int[][] boxes = new int[9][10];

    char[][] board;
    boolean solved = false;

    public boolean couldPlace(int num, int row, int col){
        int idx = (row / 3) * 3 + col / 3; // box index
        return rows[row][num] + cols[col][num] + boxes[idx][num] == 0;
    }

    public void placeNumber(int num, int row, int col){
        int idx = (row / 3) * 3 + col / 3; // box index
        rows[row][num]++;
        cols[col][num]++;
        boxes[idx][num]++;
        board[row][col] = (char)(num + '0');
    }

    public void removeNumber(int num, int row, int col){
        int idx = (row / 3) * 3 + col / 3; // box index
        rows[row][num]--;
        cols[col][num]--;
        boxes[idx][num]--;
        board[row][col] = '.';
    }

    public void placeNextNumber(int row, int col){
        if ((col == 8) && (row == 8))
            solved = true;
        else{
            if (col == 8)
                backtrack(row + 1, 0);
            else
                backtrack(row, col + 1);
        }
    }

    public void backtrack(int row, int col){
        if (board[row][col] == '.'){
            for (int num = 1; num < 10; num++){
                if (couldPlace(num, row, col)){
                    placeNumber(num, row, col);
                    placeNextNumber(row, col);
                    if (!solved)
                        removeNumber(num, row, col);
                }
            }
        }
        else
            placeNextNumber(row, col);
    }

    public void solveSudoku(char[][] board){
        this.board = board;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                char num = board[i][j];
                if (num != '.'){
                    int n = num - '0';
                    placeNumber(n, i, j);
                }
            }
        }
        backtrack(0, 0);
    }
}
