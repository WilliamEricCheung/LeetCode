package tech.wec.iLoveZQW;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightWithinKStops_787 {

    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            int[][] graph = new int[n][n];
            for (int i = 0; i < flights.length; i++)
                graph[flights[i][0]][flights[i][1]] = flights[i][2];
            Map<Integer, Integer> bestRoute = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
            pq.offer(new int[]{0, 0, src}); // 0 is cost, 1 is k (stop), 2 is node
            while(!pq.isEmpty()){
                int[] info = pq.poll();
                int cost = info[0], k = info[1], node = info[2];
                if (k > K + 1 || cost > bestRoute.getOrDefault(k * 1000 + node, Integer.MAX_VALUE)) continue;
                if (node == dst) return cost;
                for (int nei = 0; nei < n; nei++) if (graph[node][nei] > 0){
                    int newCost = cost + graph[node][nei];
                    if (newCost < bestRoute.getOrDefault((k + 1) * 1000 + nei, Integer.MAX_VALUE)){
                        pq.offer(new int[]{newCost, k + 1, nei});
                        bestRoute.put((k + 1) * nei, newCost);
                    }
                }
            }
            return -1;
        }
    }
}
