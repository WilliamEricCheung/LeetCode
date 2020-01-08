package tech.wec.BreadthFirstSearch;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops_787 {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            int[][] graph = new int[n][n];
            // build graph
            for (int[] flight: flights)
                graph[flight[0]][flight[1]] = flight[2];
            Map<Integer, Integer> bestRoute = new HashMap<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->a[0] - b[0]);
            pq.offer(new int[]{0,0, src});
            while (!pq.isEmpty()){
                int[] info = pq.poll();
                int cost = info[0], k = info[1], place = info[2];
                if (k > K + 1 || cost > bestRoute.getOrDefault(k * 1000 + place, Integer.MAX_VALUE)) continue;
                if (place == dst) return cost;
                for (int nei = 0; nei < n; nei++) if (graph[place][nei] > 0){
                    int newCost = cost + graph[place][nei];
                    if (newCost < bestRoute.getOrDefault((k + 1) * 1000 + nei, Integer.MAX_VALUE)){
                        pq.offer(new int[]{newCost, k + 1, nei});
                        bestRoute.put((k + 1) * 1000 + nei, newCost);
                    }
                }
            }
            return -1;
        }
    }
}
