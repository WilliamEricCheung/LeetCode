package tech.wec.String;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        int ans = 0;
        for (int i =0, j = 0;j<s.length();j++){
            if (indexMap.containsKey(s.charAt(j))){
                i = Math.max(indexMap.get(s.charAt(j)), i);
            }
            ans = Math.max(j - i+1, ans);
            indexMap.put(s.charAt(j), j+1);
        }
        return ans;
    }
}
