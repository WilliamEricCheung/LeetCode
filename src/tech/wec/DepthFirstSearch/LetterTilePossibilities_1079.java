package tech.wec.DepthFirstSearch;

import java.util.Arrays;

public class LetterTilePossibilities_1079 {
    class Solution {

        private int result;
        public int numTilePossibilities(String tiles) {
            if (tiles.length() == 0) return 0;
            result = -1;
            char[] arr = tiles.toCharArray();
            Arrays.sort(arr);
            boolean[] visited = new boolean[arr.length];
            dfs(arr, visited);
            return result;
        }

        private void dfs(char[] arr, boolean[] visited){
            result++;
            for (int i = 0; i < arr.length; i++){
                if (visited[i]) continue;
                if (i > 0 && arr[i] == arr[i-1] && !visited[i-1]) continue;
                visited[i] = true;
                dfs(arr, visited);
                visited[i] = false;
            }
        }
    }
}
