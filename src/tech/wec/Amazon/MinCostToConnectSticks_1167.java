package tech.wec.Amazon;

import java.util.PriorityQueue;

public class MinCostToConnectSticks_1167 {
    public int connectSticks(int[] sticks) {
        if (sticks.length <= 1)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        int length = 0;
        for (int stick : sticks){
            pq.add(stick);
        }
        while(!pq.isEmpty()){
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            result += stick1 + stick2;
            if (pq.isEmpty())
                break;
            pq.add(stick1 + stick2);
        }
        return result;
    }
}
