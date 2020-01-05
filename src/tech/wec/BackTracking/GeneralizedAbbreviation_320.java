package tech.wec.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation_320 {

    class Solution {
        // backtrack
        private List<String> ans;
        public List<String> generateAbbreviations(String word) {
            ans = new ArrayList<>();
            backtrack(word, new StringBuilder(), 0 , 0);
            return ans;
        }
        // i is the current position
        // k is the count of consecutive abbreviated characters
        private void backtrack(String word, StringBuilder temp, int i, int k){
            int len = temp.length();
            if (i == word.length()){
                // 已经递归完成
                if (k != 0)  temp.append(k);
                ans.add(temp.toString());
            }else{
                // the branch that word.chatAt(i) is abbreviated
                backtrack(word, temp, i + 1, k + 1);
                // the branch that word.chatAt(i) is kept
                if (k != 0) temp.append(k);
                temp.append(word.charAt(i));
                backtrack(word, temp, i + 1, 0);
            }
            temp.setLength(len);
        }
    }
}
