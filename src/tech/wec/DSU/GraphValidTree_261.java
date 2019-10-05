package tech.wec.DSU;

public class GraphValidTree_261 {

    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            if (dsu.find(x) != dsu.find(y))
                dsu.union(x, y);
            else
                return false;
        }
        return edges.length == n-1;
    }

    class DSU{
        int[] parent;
        public DSU(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        public int find(int x){
            if (parent[x]!=x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y){
            parent[find(x)] = find(y);
        }
    }
}
