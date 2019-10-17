package tech.wec.Google;

import java.util.HashMap;
import java.util.Map;

// Single-Row Keyboard leetCode 1165
public class TimeToTypeAString {
    public int calculateTime(String keyboard, String word){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++){
            map.put(keyboard.charAt(i),i);
        }

        char[] chars = word.toCharArray();
        int len = chars.length;
        int ans = map.get(chars[0]);
        for (int i = 1; i < len; i++){
            ans += Math.abs(map.get(chars[i]) - map.get(chars[i-1]));
        }
        return ans;
    }
}
