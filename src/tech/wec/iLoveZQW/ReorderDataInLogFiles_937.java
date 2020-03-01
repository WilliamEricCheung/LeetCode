package tech.wec.iLoveZQW;

import java.util.Arrays;
import java.util.Collections;

public class ReorderDataInLogFiles_937 {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            Arrays.sort(logs, (log1, log2)->{
                String[] sp1 = log1.split(" ", 2);
                String[] sp2 = log2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(sp1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(sp2[1].charAt(0));
                if (!isDigit1 && !isDigit2){
                    int cmp = sp1[1].compareTo(sp2[1]);
                    if (cmp != 0)
                        return cmp;
                    else
                        return sp1[0].compareTo(sp2[0]);
                }
                return isDigit1? (isDigit2? 0: 1): -1;
            });
            return logs;
        }
    }
}
