package tech.wec.Google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RedundantConnection_684 {

    // DFS
    Set<Integer> seen = new HashSet<>();
    int MAX_EDGE_VAL = 1000;
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<Integer>[] gragh = new ArrayList[MAX_EDGE_VAL + 1];
        for (int i = 0; i<=MAX_EDGE_VAL;i++)
            gragh[i] = new ArrayList<>();
        for (int[] edge : edges){
            seen.clear();
            if (!gragh[edge[0]].isEmpty() && !gragh[edge[1]].isEmpty()
            && dfs(gragh, edge[0], edge[1]))
                return edge;
            gragh[edge[0]].add(edge[1]);
            gragh[edge[1]].add(edge[0]);
        }
        throw new AssertionError();
    }

    public boolean dfs(ArrayList<Integer>[] gragh, int source, int target){
        if (!seen.contains(source)){
            seen.add(source);
            if (source == target) return true;
            for (int neighbor : gragh[source])
                if (dfs(gragh, neighbor, target)) return true;
        }
        return false;
    }

    // Union-Find
    int MAX_EDGE = 1000;
    public int[] findRedundantConnection_1(int[][] edges){
        DSU dsu = new DSU(MAX_EDGE + 1);
        for (int[] edge : edges){
            if (!dsu.union(edge[0], edge[1]))
                return edge;
        }
        throw new AssertionError();
    }

    class DSU{
        int[] parent;
        int[] rank;

        public DSU(int size){
            parent = new int[size];
            for (int i = 0; i<size;i++)
                parent[i] = i;
            rank = new int[size];
        }

        public int find(int x){
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        // x -> y
        public boolean union(int x, int y){
            int xr = find(x), yr = find(y);
            if (xr == yr)
                return false;
            else if (rank[xr] < rank[yr])
                parent[xr] = yr;
            else if (rank[xr] > rank[yr])
                parent[yr] = xr;
            else{
                parent[yr] = xr;
                rank[xr]++;
            }
            return true;
        }
    }


}
