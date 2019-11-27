package tech.wec.DepthFirstSearch;

public class FloodFill_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        image[sr][sc] = newColor;
        return dfs(image, sr, sc, oldColor);
    }

    private int[][] dfs(int[][] image, int sr, int sc, int oldColor){
        int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < 4; i++){
            int r = sr + direction[i][0];
            int c = sc + direction[i][1];
            if (r >= 0 && r < image.length && c >= 0 && c < image[0].length){
                if (image[r][c] == oldColor){
                    image[r][c] = image[sr][sc];
                    image = dfs(image, r, c, oldColor);
                }
            }
        }
        return image;
    }
}
