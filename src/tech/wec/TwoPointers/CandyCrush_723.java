package tech.wec.TwoPointers;

public class CandyCrush_723 {
    class Solution {
        public int[][] candyCrush(int[][] board) {
            int rows = board.length, cols = board[0].length;
            boolean todo = false;
            // 竖向有3个
            for (int r = 0; r < rows; r++){
                for (int c = 0; c + 2 < cols; c++){
                    int v = Math.abs(board[r][c]);
                    if (v != 0 && v == Math.abs(board[r][c+1]) && v == Math.abs(board[r][c+2])){
                        board[r][c] = board[r][c+1] = board[r][c+2] = -v;
                        todo = true;
                    }
                }
            }
            // 类似的，横向3个
            for (int r = 0; r + 2 < rows; r++){
                for (int c = 0; c < cols; c++){
                    int v = Math.abs(board[r][c]);
                    if (v != 0 && v == Math.abs(board[r+1][c]) && v == Math.abs(board[r+2][c])){
                        board[r][c] = board[r+1][c] = board[r+2][c] = -v;
                        todo = true;
                    }
                }
            }
            // 坍缩
            for (int c = 0; c < cols; c++){
                int wr = rows - 1;
                for (int r = rows - 1; r >= 0; r--){
                    if (board[r][c] > 0)
                        board[wr--][c] = board[r][c];
                }
                while(wr >= 0)
                    board[wr--][c] = 0;
            }
            return todo? candyCrush(board): board;
        }
    }
}
