package tech.wec.Facebook;

import java.util.*;

public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> result = new HashMap<>();
        for (String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (!result.containsKey(sorted)) result.put(sorted,new ArrayList());
            result.get(sorted).add(str);
        }
        return new ArrayList(result.values());
    }
}
