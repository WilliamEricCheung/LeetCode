package tech.wec.SlidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters_159 {
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            if (s.length() <= 2) return s.length();
            int left = 0, right = 0;
            // character: its rightmost position
            Map<Character, Integer> map = new HashMap<>();
            int max = 2;
            while(right < s.length()){
                if (map.size() <= 2)
                    map.put(s.charAt(right), right++);
                if (map.size() == 3){
                    int idx = Collections.min(map.values());
                    map.remove(s.charAt(idx));
                    left = idx + 1;
                }
                max = Math.max(max, right - left);
            }
            return max;
        }
    }
}
