package tech.wec.Google;

public class ShortestWayToFormString_1055 {
    public int shortestWay(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        // used for find invalid
        int[] sCount  = new int[26];
        int[] tCount = new int[26];
        for (char ch: s)
            sCount[ch - 'a']++;
        for (char ch: t)
            tCount[ch - 'a']++;
        for (int i = 0; i < 26; i++){
            if (tCount[i]> 0 && sCount[i] == 0)
                return -1;
        }

        int idx = 0;
        int cnt = 1;
        for (int i = 0; i < t.length; i++){
            if (idx == s.length){
                cnt++;
                idx = 0;
            }
            while(s[idx] != t[i]){
                idx++;
                if (idx == s.length){
                    idx =0;
                    cnt++;
                }
            }
            idx++;
        }
        return cnt;
    }
}
