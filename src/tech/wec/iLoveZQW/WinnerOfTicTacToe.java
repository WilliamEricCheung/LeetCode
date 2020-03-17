package tech.wec.iLoveZQW;

public class WinnerOfTicTacToe {

    public static void main(String[] args) {
        int[][] board = new int[][]{{1, 2, 0}, {1, 1, 0}, {2, 0, 0}};
        TicTacToe test = new TicTacToe(board, 3);
        System.out.print(test.winner());
    }

    static class TicTacToe{
        int[][] board;
        int[] rows; // 一行上有多少+1或者-1
        int[] cols; // 一列上有多少+1或者-1
        int diag1; // 从左上到右下的对角线
        int diag2; // 从右上到左下的对角线
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        public TicTacToe(int[][] board,int n){
            this.board = board;
            rows = new int[n];
            cols = new int[n];
        }

        public int winner(){
            int player = 0;
            int n = rows.length;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0) {
                        player++;
                        int win = move(i, j, board[i][j]);
                        if (win != 0) return win;
                    }
                }
            }
            player = (player % 2 == 0)? 1: 2;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++) {
                    int win = backtrack(i, j, player);
                    if(win != 0) return win;
                }
            }
            return 0;
        }

        /**
         * @param row
         * @param col
         * @param player 当前玩家 1, 2表示
         * @return 0平手，1 玩家1赢了，2 玩家2赢了
         */
        public int move(int row, int col, int player){
            if (board[row][col] == 0){
                board[row][col] = player;
                if (checkBoard(row, col, player == 1? 1: -1)) return player;
            }
            return 0;
        }

        /**
         * 尝试一下，如果失败取消上一次尝试
         * @param row
         * @param col
         * @param player
         */
        public int backtrack(int row, int col, int player){
            int nextPlayer = player == 1? 2: 1;
            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 0) {
                int win = move(row, col, player);
                if (win == player) return win;
                else if (win != 0) {
                    // reset the location
                    resetBoard(row, col, player == 1 ? 1 : -1);
                    // try another location
                    for (int i = 0; i < directions.length; i++) {
                        int nr = row + directions[i][0];
                        int nc = col + directions[i][1];
                        backtrack(nr, nc, player);
                    }
                } else {
                    // still no result
                    // another player try another location
                    for (int i = 0; i < directions.length; i++) {
                        int nr = row + directions[i][0];
                        int nc = col + directions[i][1];
                        backtrack(nr, nc, nextPlayer);
                    }
                }
            }
            return 0; // no winner
        }
        /**
         *
         * @param row
         * @param col
         * @param player +1 代表玩家1，-1代表玩家2
         * @return
         */
        public void resetBoard(int row, int col, int player){
            board[row][col] = 0;
            int n = rows.length;
            rows[row] -= player;
            cols[col] -= player;
            if (row == col) diag1 -= player;
            if (row + col == n - 1) diag2 -= player;
        }

        public boolean hasWinner(){
            int n = rows.length;
            if (Math.abs(diag1) == n || Math.abs(diag2) == n)
                return true;
            for (int i = 0; i < n; i++){
                if (Math.abs(rows[i]) == n || Math.abs(cols[i]) == n)
                    return true;
            }
            return false;
        }

        /**
         *
         * @param row
         * @param col
         * @param player +1 代表玩家1，-1代表玩家2
         * @return
         */
        public boolean checkBoard(int row, int col, int player){
            int n = rows.length;
            rows[row] += player;
            cols[col] += player;
            if (row == col) diag1 += player;
            if (row + col == n - 1) diag2 += player;
            if (Math.abs(diag1) == n || Math.abs(diag2) == n ||
                    Math.abs(rows[row]) == n || Math.abs(cols[col]) == n)
                return true;
            return false;
        }
    }
}
