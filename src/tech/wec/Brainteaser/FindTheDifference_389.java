package tech.wec.Brainteaser;

import java.util.Arrays;

public class FindTheDifference_389 {
    public char findTheDifference(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for (int i =0;i<ss.length;i++){
            if (ss[i] != tt[i])
                return tt[i];
        }
        return tt[tt.length-1];
    }
}
