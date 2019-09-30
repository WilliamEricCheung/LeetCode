package tech.wec.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings_249 {
    // using bit manipulation
    public List<List<String>> groupStrings_1(String[] strings) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String string: strings){
            int key = 1;
            for (int i = 0; i < string.length()-1; i++){
                key <<= 2;
                key += (string.charAt(i+1) - string.charAt(i) + 26) % 26;
            }
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(string);
        }
        return new ArrayList<>(map.values());
    }

    // direct
    public List<List<String>> groupStrings(String[] strings){
        Map<String, List<String>> map = new HashMap<>();
        for (String string:strings) {
            String conv = convert(string);
            if (map.containsKey(conv)) {
                map.get(conv).add(string);
            } else {
                map.put(conv, new ArrayList<>());
                map.get(conv).add(string);
            }
        }
        return new ArrayList<>(map.values());
    }

    // convert s to key which started from a
    private String convert(String s){
        int len = s.length();
        if (len == 1) return "a";
        int diff = s.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        for (int i = 1;i<len;i++){
            char c = s.charAt(i);
            char ch = (char)((c - diff + 26 - 'a') % 26 + 'a');
            sb.append(ch);
        }
        return sb.toString();
    }
}
