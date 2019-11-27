package tech.wec.String;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation_266 {
    public boolean canPermutePalindrome(String s) {
        int single = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch: s.toCharArray())
            map.put(ch,map.getOrDefault(ch, 0) + 1);
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            if (entry.getValue() % 2 == 1) single++;
        }
        return single <= 1;
    }
}
