package tech.wec.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing_465 {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> debt = new HashMap<>();
        for (int [] trans : transactions){
            debt.put(trans[0], debt.getOrDefault(trans[0], 0) + trans[2]);
            debt.put(trans[1], debt.getOrDefault(trans[1], 0) - trans[2]);
        }
        return dfs(0, new ArrayList<>(debt.values()));
    }

    private int dfs(int start, List<Integer> debt){
        while(start < debt.size() && debt.get(start) == 0)
            start++;
        if (start == debt.size()) return 0;
        int cnt = Integer.MAX_VALUE;
        for (int i = start + 1; i < debt.size(); i++){
            if (debt.get(i) * debt.get(start) < 0){
                debt.set(i, debt.get(i) + debt.get(start));
                cnt = Math.min(cnt, 1 + dfs(start + 1, debt));
                debt.set(i, debt.get(i) - debt.get(start));
            }
        }
        return cnt;
    }
}
