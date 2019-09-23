package tech.wec.Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation_288 {
    // brute force
    class ValidWordAbbr {
        private String[] dictionary;
        public ValidWordAbbr(String[] dictionary) {
            this.dictionary = dictionary;
        }

        public boolean isUnique(String word) {
            int n = word.length();
            for (String s:dictionary){
                if (word.equals(s))
                    continue;
                int m = s.length();
                if (m==n &&s.charAt(0) == word.charAt(0)&&s.charAt(m-1) == word.charAt(n-1))
                    return false;
            }
            return true;
        }
    }

    class ValidWordAbbr_1{
        // key -> abbr, value -> different words
        private Map<String, Set<String>> abbrDict = new HashMap<>();
        public ValidWordAbbr_1(String[] dictionary){
            for (String s: dictionary){
                String abbr = toAbbr(s);
                Set<String> words = abbrDict.containsKey(abbr) ? abbrDict.get(abbr) : new HashSet<>();
                words.add(s);
                abbrDict.put(abbr, words);
            }
        }
        public boolean isUnique(String word) {
            String abbr = toAbbr(word);
            Set<String> words = abbrDict.get(abbr);
            return words == null || (words.size() ==1 && words.contains(word));
        }

        private String toAbbr(String s){
            int n = s.length();
            if (n<=2)
                return s;
            return s.charAt(0)+Integer.toString(n-2)+s.charAt(n-1);
        }
    }
    /**
     * Your ValidWordAbbr object will be instantiated and called as such:
     * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
     * boolean param_1 = obj.isUnique(word);
     */
}
