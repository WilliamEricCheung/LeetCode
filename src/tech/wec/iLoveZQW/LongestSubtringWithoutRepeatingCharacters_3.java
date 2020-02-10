package tech.wec.iLoveZQW;

import java.util.HashMap;
import java.util.Map;

public class LongestSubtringWithoutRepeatingCharacters_3 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> indexMap = new HashMap<>();
            int longest = 0;
            for (int i = 0, j = 0; j < s.length(); j++){
                if (indexMap.containsKey(s.charAt(j))){
                    i = Math.max(indexMap.get(s.charAt(j)), i);
                }
                longest = Math.max(j - i + 1, longest);
                indexMap.put(s.charAt(j), j + 1);
            }
            return longest;
        }
    }
}
