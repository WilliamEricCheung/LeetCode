package tech.wec.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KeyboardRow_500 {
    static Map<Character, Integer> dic1 = new HashMap<>();
    static Map<Character, Integer> dic2 = new HashMap<>();
    static Map<Character, Integer> dic3 = new HashMap<>();
    static {
        dic1.put('q', 1);
        dic1.put('w', 1);
        dic1.put('e', 1);
        dic1.put('r', 1);
        dic1.put('t', 1);
        dic1.put('y', 1);
        dic1.put('u', 1);
        dic1.put('i', 1);
        dic1.put('o', 1);
        dic1.put('p', 1);
        dic2.put('a', 2);
        dic2.put('s', 2);
        dic2.put('d', 2);
        dic2.put('f', 2);
        dic2.put('g', 2);
        dic2.put('h', 2);
        dic2.put('j', 2);
        dic2.put('k', 2);
        dic2.put('l', 2);
        dic3.put('z', 3);
        dic3.put('x', 3);
        dic3.put('c', 3);
        dic3.put('v', 3);
        dic3.put('b', 3);
        dic3.put('n', 3);
        dic3.put('m', 3);
    }
    public String[] findWords(String[] words) {
        String[] res = new String[words.length];
        int cur = 0;
        for(String word: words){
            if (word.length() == 0) continue;
            if (word.length() == 1) res[cur++] = word;
            String str = word.toLowerCase();
            char ch = str.charAt(0);
            int flag = findDic(ch);
            for (int i =1;i<str.length();i++){
                if (findDic(str.charAt(i)) != flag)
                    break;
                if (i == str.length()-1)
                    res[cur++] = word;
            }
        }
        return Arrays.copyOf(res, cur);
    }

    private int findDic(char ch){
        int flag = 0;
        if (dic1.containsKey(ch))
            flag = 1;
        else if (dic2.containsKey(ch))
            flag = 2;
        else if (dic3.containsKey(ch))
            flag = 3;
        return flag;
    }
}
