package tech.wec.String;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, "",0,0, n);
        return ans;
    }

    private void backTrack(List<String> ans, String cur, int open, int close, int limit){
        if (cur.length() == limit * 2){
            ans.add(cur);
            return;
        }
        if (open < limit)
            backTrack(ans, cur+"(", open + 1, close, limit);
        if (close < open)
            backTrack(ans, cur+")", open, close + 1, limit);
    }
}
