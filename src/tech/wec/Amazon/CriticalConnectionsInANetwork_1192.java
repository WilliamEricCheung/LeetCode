package tech.wec.Amazon;

import java.util.*;

public class CriticalConnectionsInANetwork_1192 {

    static List<List<Integer>> result;
    static boolean[] visited;
    static int[] low;
    static int[] order;
    static int count = 0;
    static Map<Integer, List<Integer>> map;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<>());
        for (List<Integer> con : connections){
            int a = con.get(0);
            int b = con.get(1);
            map.get(a).add(b);
            map.get(b).add(a);
        }
        order = new int[n];
        low = new int[n];
        visited = new boolean[n];
        Arrays.fill(visited, false);
        result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (!visited[i])
                dfs(i, i);
        return result;
    }

    private void dfs(int v, int parent){
        visited[v] = true;
        order[v] = low[v] = ++count;
        for (int w : map.get(v)){
            if (!visited[w]){
                dfs(w, v);
                low[v] = Math.min(low[w], low[v]);
                if (low[w] > order[v]){
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(v);
                    bridge.add(w);
                    result.add(bridge);
                }
            }else if (w != parent)
                low[v] = Math.min(low[v], low[w]);
        }
    }
}
