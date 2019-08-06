package tech.wec.Brainteaser;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i)) && (map.get(s.charAt(i))!=t.charAt(i)))
                return false;
            if (!map.containsKey(s.charAt(i)) && map.containsValue(t.charAt(i)))
                return false;
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
