package tech.wec.HashTable;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] table = new int[26];
        for (int i =0;i<s.length();i++)
            table[s.charAt(i)-'a']++;
        for (int j =0;j<t.length();j++){
            table[t.charAt(j)-'a']--;
            if (table[t.charAt(j)-'a']<0)
                return false;
        }
        return true;
    }
}
