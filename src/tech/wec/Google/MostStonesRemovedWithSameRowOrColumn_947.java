package tech.wec.Google;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MostStonesRemovedWithSameRowOrColumn_947 {

    public int removeStones(int[][] stones){
        int n = stones.length;
        int[][] gragh = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    gragh[i][++gragh[i][0]] = j;
                    gragh[j][++gragh[j][0]] = i;
                }
            }
        }
        int ans = 0;
        boolean[] seen = new boolean[n];
        for (int i  = 0; i<n; ++i) if (!seen[i]){
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            seen[i] = true;
            ans--;
            while(!stack.isEmpty()){
                int node = stack.pop();
                ans++;
                for (int k = 1; k <= gragh[node][0]; ++k){
                    int neighbor = gragh[node][k];
                    if (!seen[neighbor]){
                        stack.push(neighbor);
                        seen[neighbor] = true;
                    }
                }
            }
        }
        return ans;
    }

    // DSU
    public int removeStones_1(int[][] stones){
        int n = stones.length;
        DSU dsu = new DSU(20000);
        for (int[] stone: stones){
            dsu.union(stone[0], stone[1] + 10000);
        }
        Set<Integer> seen = new HashSet<>();
        for (int[] stone: stones)
            seen.add(dsu.find(stone[0]));
        return n - seen.size();
    }

    class DSU{
        int[] parent;
        public DSU(int n){
            parent = new int[n];
            for (int i =  0;i < n; i++)
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
