package tech.wec.iLoveZQW;

public class FriendCircles_547 {
    class Solution {
        public int findCircleNum(int[][] M) {
            int[] visited = new int[M.length];
            int cnt = 0;
            for (int i = 0; i < M.length; i++){
                if (visited[i] == 0){
                    dfs(M, visited, i);
                    cnt++;
                }
            }
            return cnt;
        }

        private void dfs(int[][] M, int[] visited, int i){
            for (int j = 0; j < M.length; j++){
                if (M[i][j] == 1 && visited[j] == 0){
                    visited[j] = 1;
                    dfs(M, visited, j);
                }
            }
        }
    }
}
