package tech.wec.DSU;

public class SurroundedRegions_130 {

    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        for (int i = 0; i < board.length; i++){
            BFS(board, i, 0);
            BFS(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board[0].length; i++){
            BFS(board, 0, i);
            BFS(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '0') board[i][j] = 'X';
                if (board[i][j] == 'V') board[i][j] = '0';
            }
        }
    }

    private void BFS(char[][] board, int row, int col){
        if (row >= 0 && row < board.length &&
        col >= 0 && col < board[0].length && board[row][col] == '0') {
            board[row][col] = 'V';
            BFS(board, row - 1, col);
            BFS(board, row + 1, col);
            BFS(board, row, col - 1);
            BFS(board, row, col + 1);
        }
    }
}
