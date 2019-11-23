package tech.wec.String;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring_76 {
    public String minWindow_1(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length();i++){
            int cnt = dict.getOrDefault(t.charAt(i), 0);
            dict.put(t.charAt(i), cnt + 1);
        }
        int required = dict.size();
        int l = 0, r = 0;
        int formed = 0;
        Map<Character, Integer> window = new HashMap<>();
        int[] ans = {-1,0,0};
        while(r < s.length()){
            char ch = s.charAt(r);
            int cnt = window.getOrDefault(ch, 0);
            window.put(ch, cnt + 1);
            if (dict.containsKey(ch) && window.get(ch).intValue() == dict.get(ch).intValue())
                formed++;
            while(l <= r && formed == required){
                ch = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]){
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                window.put(ch, window.get(ch) - 1);
                if (dict.containsKey(ch) && window.get(ch).intValue() < dict.get(ch).intValue())
                    formed--;
                l++;
            }
            r++;
        }
        return ans[0] == -1? "": s.substring(ans[1], ans[2] + 1);
    }

    // optimized
    public String minWindow(String s, String t){
        if (s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length();i++){
            int cnt = dict.getOrDefault(t.charAt(i), 0);
            dict.put(t.charAt(i), cnt + 1);
        }
        int required = dict.size();
        List<Pair<Integer, Character>> filteredS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (dict.containsKey(ch))
                filteredS.add(new Pair<>(i, ch));
        }
        int l = 0, r = 0;
        int formed = 0;
        Map<Character, Integer> window = new HashMap<>();
        int[] ans = {-1,0,0};
        while(r < filteredS.size()){
            char ch = filteredS.get(r).getValue();
            int cnt = window.getOrDefault(ch, 0);
            window.put(ch, cnt + 1);
            if (dict.containsKey(ch) && window.get(ch).intValue() == dict.get(ch).intValue())
                formed++;
            while(l <= r && formed == required){
                ch = filteredS.get(l).getValue();
                int end = filteredS.get(r).getKey();
                int start = filteredS.get(l).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]){
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }
                window.put(ch, window.get(ch) - 1);
                if (dict.containsKey(ch) && window.get(ch).intValue() < dict.get(ch).intValue())
                    formed--;
                l++;
            }
            r++;
        }
        return ans[0] == -1? "": s.substring(ans[1], ans[2] + 1);
    }
}
