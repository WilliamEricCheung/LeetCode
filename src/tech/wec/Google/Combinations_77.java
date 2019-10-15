package tech.wec.Google;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

    private List<List<Integer>> result = new ArrayList<>();
    private int n;
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new ArrayList<>());
        return result;
    }

    private void backtrack(int num, List<Integer> added){
        if (added.size() == k){
            result.add(new ArrayList<>(added));
            return;
        }
        for (int i = num; i <= n; i++){
            added.add(i);
            backtrack(i + 1, added);
            added.remove(added.size() - 1);
        }
    }
}
