package tech.wec.Google;

public class SwapAdjacentInLRString_777 {
    public boolean canTransform(String start, String end) {
        int len = start.length();
        char[] s = start.toCharArray(), e = end.toCharArray();
        int i = -1, j = -1;
        while(++i < len && ++j < len){
            while(i < len && s[i] == 'X') i++;
            while(j < len && e[j] == 'X') j++;
            if ((i < len) ^ (j < len)) return false;
            if (i < len && j < len){
                if (s[i]!= e[j] || (s[i] == 'R'&& i > j)||
                        (s[i]=='L'&& i<j))
                    return false;
            }
        }
        return true;
    }
}
