package tech.wec.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {

    class Coordinate{
        int x;
        int y;
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int getStep(char[][] island){
        if (island==null || island.length == 0) return 0;
        // 初始化
        int steps = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0,0));
        boolean[][] visited = new boolean[island.length][island[0].length];
        visited[0][0] = true;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        // bfs
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Coordinate cord = queue.poll();
                int x = cord.x;
                int y = cord.y;
                if (island[x][y] == 'X') return steps;
                for (int[] direction : directions){
                    int newX = x + direction[0];
                    int newY = y + direction[0];
                    if (newX >= 0 && newX< island.length && newY>=0 && newY<island[0].length &&
                    island[newX][newY] != 'D' && !visited[newX][newY]){
                        queue.add(new Coordinate(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}
