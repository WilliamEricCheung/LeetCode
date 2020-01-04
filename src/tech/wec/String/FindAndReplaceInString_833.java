package tech.wec.String;

import java.util.Arrays;

public class FindAndReplaceInString_833 {
    class Solution {
        public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
            StringBuilder sb = new StringBuilder();
            int[] idx = new int[S.length()]; // 记录哪些字符是被匹配的
            Arrays.fill(idx, -1);
            for (int i = 0; i < indexes.length; i++){
                int ix = indexes[i];
                if (S.substring(ix, ix + sources[i].length()).equals(sources[i])){
                    idx[ix] = i;
                }
            }
            int ix = 0;
            while(ix < S.length()){
                if (idx[ix] >= 0){
                    sb.append(targets[idx[ix]]);
                    ix += sources[idx[ix]].length();
                }else sb.append(S.charAt(ix++));
            }
            return sb.toString();
        }
    }
}
