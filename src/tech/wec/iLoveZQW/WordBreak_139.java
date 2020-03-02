package tech.wec.iLoveZQW;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            Set<String> dict = new HashSet<>(wordDict);
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++){
                for (int j = 0; j < i; j++){
                    if (dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
