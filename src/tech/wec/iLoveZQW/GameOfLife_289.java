package tech.wec.iLoveZQW;

public class GameOfLife_289 {
    class Solution {

        public void gameOfLife(int[][] board) {
            int rows = board.length;
            int cols = board[0].length;
            int[] directions = new int[]{0,-1,1};
            for (int r = 0; r < rows; r++){
                for (int c = 0; c < cols; c++){
                    int live = 0;
                    for (int i = 0; i < 3; i++){
                        for (int j = 0; j < 3; j++){

                            if (!(directions[i] == 0 && directions[j] == 0)){
                                int nr = r + directions[i];
                                int nc = c + directions[j];
                                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                                        && Math.abs(board[nr][nc]) == 1){
                                    live++;
                                }
                            }
                        }
                    }

                    // rule 1 and 3
                    if (board[r][c] == 1 && (live < 2 || live > 3))
                        board[r][c] = -1;
                    // rule 4
                    if (board[r][c] == 0 && live == 3)
                        board[r][c] = 2;
                }
            }
            // rearrange it
            for (int r = 0; r < rows; r++){
                for (int c = 0; c < cols; c++) {
                    if (board[r][c] <= 0) board[r][c] = 0;
                    else board[r][c] = 1;
                }
            }
        }
    }
}
