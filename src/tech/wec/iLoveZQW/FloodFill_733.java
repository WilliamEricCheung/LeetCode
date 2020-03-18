package tech.wec.iLoveZQW;

public class FloodFill_733 {
    class Solution {

        private int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int oldColor = image[sr][sc];
            if (oldColor == newColor) return image;
            image[sr][sc] = newColor;
            return dfs(image, sr, sc, oldColor);
        }

        private int[][] dfs(int[][] image, int sr, int sc, int oldColor){
            for (int[] dir: directions){
                int x = sr + dir[0];
                int y = sc + dir[1];
                if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == oldColor){
                    image[x][y] = image[sr][sc];
                    image = dfs(image, x, y, oldColor);
                }
            }
            return image;
        }
    }
}
