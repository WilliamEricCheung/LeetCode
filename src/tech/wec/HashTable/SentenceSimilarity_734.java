package tech.wec.HashTable;

import java.util.*;

public class SentenceSimilarity_734 {
    class Solution {
        public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
            if (words1.length != words2.length) return false;
            Set<String> set = new HashSet<>();
            for (List<String> pair: pairs){
                set.add(pair.get(0) + "#" + pair.get(1));
                set.add(pair.get(1) + "#" + pair.get(0));
            }
            for (int i = 0; i < words1.length; i++){
                if (words1[i].equals(words2[i]) || set.contains(words1[i] + "#" + words2[i]) ||
                set.contains(words2[i] + "#" + words1[i])) continue;
                else
                    return false;
            }
            return true;
        }
    }
}
