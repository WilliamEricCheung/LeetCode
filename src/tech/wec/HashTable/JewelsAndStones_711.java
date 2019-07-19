package tech.wec.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JewelsAndStones_711 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i =0;i<J.length();i++)
            set.add(J.charAt(i));
        int cnt = 0;
        for (int i =0;i<S.length();i++){
            if (set.contains(S.charAt(i))){
                cnt++;
            }
        }
        return cnt;
    }
}
