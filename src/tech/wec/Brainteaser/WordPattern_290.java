package tech.wec.Brainteaser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern_290 {

    public boolean wordPattern(String pattern, String str) {
        if (pattern.length() == 0 || str.length() == 0) return false;
        String[] strings = str.split(" ");
        if (strings.length == 0 || strings.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i =0;i<pattern.length();i++){
            if (map.get(pattern.charAt(i)) == null){
                if (map.containsValue(strings[i])) return false;
                map.put(pattern.charAt(i), strings[i]);
            }else{
                if (!strings[i].equals(map.get(pattern.charAt(i))))
                    return false;
            }
        }
        return true;
    }
}
