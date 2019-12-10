package tech.wec.Amazon;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MovingRobot {
    final static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    static Pair<Integer, Integer> target;
    public static void main(String[] args) {
        // 0代表不可通过的格⼦，1代表可通过，2是⽬的地
        int[][] board = {
                {1,0,1,1,2,0},
                {1,0,1,0,0,1},
                {1,0,1,1,0,1},
                {1,1,0,1,0,1},
                {1,1,1,1,1,1}
        };
        System.out.println(shorestPath(board));
    }

    static class Locale{
        private int x;
        private int y;
        private int d;

        public Locale(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getD() {
            return d;
        }

        public void setD(int d) {
            this.d = d;
        }
    }

    static public int shorestPath(int[][] board){
        int cols = board.length, rows = board[0].length;
        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                if (board[i][j] == 2){
                    target = new Pair<>(i, j);
                    break;
                }
            }
        }
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        PriorityQueue<Locale> pq = new PriorityQueue<>(
                new Comparator<Locale>() {
                    @Override
                    public int compare(Locale a, Locale b) {
                        int dist1 = a.d + Math.abs(a.x - target.getKey()) + Math.abs(a.y - target.getValue());
                        int dist2 = b.d + Math.abs(b.x - target.getKey()) + Math.abs(b.y - target.getValue());
                        return dist1 - dist2;
                    }
                }
        );
        pq.add(new Locale(0,0, 0));
        visited.add(new Pair<>(0,0));
        while(!pq.isEmpty()){
            Locale cur = pq.poll();
            int d = cur.d, x = cur.x, y = cur.y;
            if (board[x][y] == 2) return d;
            for (int i = 0; i < 4; i++){
                int nx = x + directions[i][0], ny = y + directions[i][1];
                if (nx >= cols || ny >= rows || nx < 0 || ny < 0 || board[nx][ny] == 0 || visited.contains(new Pair<>(nx, ny))) continue;
                pq.add(new Locale(nx, ny, d + 1));
                visited.add(new Pair<>(nx, ny));
            }
        }
        return -1;
    }
}
