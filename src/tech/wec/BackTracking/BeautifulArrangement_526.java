package tech.wec.BackTracking;

public class BeautifulArrangement_526 {
    class Solution {
        private int cnt;
        public int countArrangement(int n) {
            cnt = 0;
            boolean[] visited = new boolean[n + 1];
            backtrack(n, 1, visited);
            return cnt;
        }

        private void backtrack(int n, int i, boolean[] visited){
            if (i > n) cnt++;
            for (int k = 1; k <= n; k++){
                if (!visited[k] && (i % k == 0 || k % i == 0)){
                    visited[k] = true;
                    backtrack(n ,i + 1, visited);
                    visited[k] = false;
                }
            }
        }
    }
}
