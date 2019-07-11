package tech.wec.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LastStoneWeight_1046 {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int cur = stones.length-2;
        int len = stones.length;
        if (stones.length == 1)
            return stones[0];
        while(cur >= 0){
            stones[cur] = Math.abs(stones[cur+1] - stones[cur]);
            cur--;
            stones = Arrays.copyOf(stones, --len);
            Arrays.sort(stones);
        }
        return stones[0];
    }
}
