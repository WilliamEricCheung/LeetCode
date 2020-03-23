package tech.wec.iLoveZQW;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord_819 {
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            paragraph += ".";
            Map<String, Integer> counter = new HashMap<>();
            Set<String> set = new HashSet<>();
            for (String ban: banned) set.add(ban);
            String ans = "";
            int freq = 0;
            StringBuilder sb = new StringBuilder();
            for (char ch: paragraph.toCharArray()){
                if (Character.isLetter(ch)) sb.append(Character.toLowerCase(ch));
                else if (sb.length() > 0){
                    String word = sb.toString();
                    if (!set.contains(word)){
                        counter.put(word, counter.getOrDefault(word, 0) + 1);
                        if (counter.get(word) > freq){
                            ans = word;
                            freq = counter.get(word);
                        }
                    }
                    sb = new StringBuilder();
                }
            }
            return ans;
        }
    }
}
