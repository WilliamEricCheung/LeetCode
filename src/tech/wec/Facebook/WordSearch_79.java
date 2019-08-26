package tech.wec.Facebook;

public class WordSearch_79 {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        int height = board.length;
        int weight = board[0].length;
        for (int i =0;i<height;i++){
            for (int j=0;j<weight;j++){
                if (backtrack(board, word, visited,i,j))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int x, int y){
        if (word.isEmpty())
            return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length ||
        visited[x][y] || word.charAt(0) != board[x][y])
            return false;

        visited[x][y] = true;
        if (backtrack(board, word.substring(1), visited, x-1,y)
        || backtrack(board, word.substring(1), visited, x+1,y)
        || backtrack(board, word.substring(1), visited, x,y-1)
        || backtrack(board, word.substring(1), visited, x,y+1))
            return true;
        visited[x][y] = false;
        return false;
    }
}
