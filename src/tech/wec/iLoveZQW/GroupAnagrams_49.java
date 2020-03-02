package tech.wec.iLoveZQW;

import java.util.*;

public class GroupAnagrams_49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> groups = new HashMap<>();
            for (String str: strs) {
                String form = format(str);
                if (groups.containsKey(form)) {
                    groups.get(form).add(str);
                } else {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(str);
                    groups.put(form, tmp);
                }
            }
            return new ArrayList<>(groups.values());
        }

        private String format(String str){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return Arrays.toString(chars);
        }
    }
}
