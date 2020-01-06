package tech.wec.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers_386 {
    // sort
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= n; i++)
                result.add(i);
            Collections.sort(result, new Comparator<Integer>() {
                @Override
                public int compare(Integer t1, Integer t2) {
                    String str1 = t1.toString();
                    String str2 = t2.toString();
                    return str1.compareTo(str2);
                }
            });
            return result;
        }
    }
    // dfs
    class Solution_1 {
        List<Integer> result;
        public List<Integer> lexicalOrder(int n){
            result = new ArrayList<>();
            dfs(0, n);
            return result;
        }

        private void dfs(int start, int n){
            for (int i = 0; i <= 9; i++){
                int num = start * 10 + i;
                if (num > 0 && num <= n){
                    result.add(num);
                    dfs(num, n);
                }
            }
        }
    }
}
