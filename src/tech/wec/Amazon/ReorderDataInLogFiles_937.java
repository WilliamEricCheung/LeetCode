package tech.wec.Amazon;

import java.util.Arrays;

public class ReorderDataInLogFiles_937 {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) ->{
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDisgit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDisgit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDisgit1 && !isDisgit2){
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0)
                    return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDisgit1? (isDisgit2? 0: 1) : -1;
        });
        return logs;
    }
}
