package tech.wec.iLoveZQW;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    class Solution {
        private List<String> ans;
        public List<String> generateParenthesis(int n) {
            ans = new ArrayList<>();
            generate("", 0, 0, n);
            return ans;
        }

        private void generate(String cur, int open, int close, int n){
            if (cur.length() == n * 2) {
                ans.add(cur);
                return;
            }
            if (open < n) generate(cur+"(", open + 1, close, n);
            if (close < open) generate(cur + ")", open, close + 1, n);
        }
    }
}
