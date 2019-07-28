package tech.wec.Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString_438 {

    public List<Integer> findAnagrams(String s, String p) {
        int[] pDic= new int[26];
        int[] sDic = new int[26];
        Arrays.fill(pDic, 0);
        Arrays.fill(sDic, 0);
        List<Integer> result= new ArrayList<>();
        for (char ch: p.toCharArray())
            pDic[ch - 'a']++;
        for (int i =0;i+1<p.length() && i<s.length();i++)
            sDic[s.charAt(i) - 'a']++;
        for (int i =0;i+p.length() <= s.length();i++){
            sDic[s.charAt(i+p.length()-1) - 'a']++;
            if (Arrays.equals(pDic, sDic))
                result.add(i);
            sDic[s.charAt(i) - 'a']--;
        }
        return result;
    }
}
