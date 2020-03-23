package tech.wec.iLoveZQW;

import java.util.LinkedList;
import java.util.Queue;

public class WordSearch_79 {
    class Solution {

        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0].length == 0)
                return false;
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length;j++){
                    if (dfs(board, word, 0, i, j, visited)) return true;
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited){
            if (index >= word.length()) return true;
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length ||
                    visited[x][y] || board[x][y] != word.charAt(index))
                return false;

            visited[x][y] = true;
            if (dfs(board, word, index + 1, x + 1, y, visited) ||
            dfs(board, word, index + 1, x - 1, y, visited) ||
            dfs(board, word, index + 1, x, y + 1, visited) ||
            dfs(board, word, index + 1, x, y - 1, visited))
                return true;
            visited[x][y] = false;
            return false;
        }
    }
}
