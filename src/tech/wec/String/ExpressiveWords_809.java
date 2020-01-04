package tech.wec.String;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords_809 {
    class Solution {

        class StringEncode{
            // convert
            // abbcccddddaaaaa -> abcda [1,2,3,4,5]
            String key;
            List<Integer> counts;

            public StringEncode(String str){
                StringBuilder sb = new StringBuilder();
                counts = new ArrayList<>();
                int prev = -1;
                for (int i = 0; i < str.length(); i++){
                    if (i == str.length() - 1 || str.charAt(i) != str.charAt(i+1)){
                        sb.append(str.charAt(i));
                        counts.add(i - prev);
                        prev = i;
                    }
                }
                key = sb.toString();
            }
        }

        public int expressiveWords(String S, String[] words) {
            StringEncode target = new StringEncode(S);
            int result = 0;
            for (String word: words){
                StringEncode pattern = new StringEncode(word);
                boolean flag = false;
                if (!target.key.equals(pattern.key)) continue;
                for (int i = 0; i < target.counts.size(); i++){
                    int cTarget = target.counts.get(i);
                    int cPattern = pattern.counts.get(i);
                    if (cTarget < cPattern) {
                        flag = false;
                        break;
                    }
                    else if (cTarget >= 3 || (cTarget < 3 && cTarget == cPattern)) flag = true;
                    else{
                        flag = false;
                        break;
                    }
                }
                if (flag) result++;
            }
            return result;
        }
    }
}
