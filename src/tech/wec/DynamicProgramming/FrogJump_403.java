package tech.wec.DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump_403 {
    class Solution {
        public boolean canCross(int[] stones) {
            // key refers to the position at which a stone is present
            // value is a set containing the jump size which can lead to the current stone position
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < stones.length; i++)
                map.put(stones[i], new HashSet<>());
            map.get(0).add(0);
            for (int i = 0; i < stones.length; i++){
                for (int k: map.get(stones[i])){
                    for (int step = k - 1; step <= k + 1; step++){
                        if (step > 0 && map.containsKey(stones[i] + step))
                            map.get(stones[i] + step).add(step);
                    }
                }
            }
            return map.get(stones[stones.length - 1]).size() > 0;
        }
    }
}
