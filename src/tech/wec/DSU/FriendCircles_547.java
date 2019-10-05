package tech.wec.DSU;

import java.util.Arrays;

public class FriendCircles_547 {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (M[i][j] == 1 && i != j)
                    dsu.union(i, j);
            }
        }
        return dsu.count();
    }

    class DSU{
        int[] parent;
        public DSU(int n){
            parent = new int[n];
            Arrays.fill(parent, -1);
        }

        public int find(int x){
            if (parent[x] == -1)
                return x;
            return find(parent[x]);
        }

        public void union(int x, int y){
            int xr = find(x);
            int yr = find(y);
            if (xr != yr)
                parent[xr] = yr;
        }

        public int count(){
            int cnt = 0;
            for (int i = 0; i < parent.length; i++)
                if (parent[i] == -1)
                    cnt++;
            return cnt;
        }
    }
}
