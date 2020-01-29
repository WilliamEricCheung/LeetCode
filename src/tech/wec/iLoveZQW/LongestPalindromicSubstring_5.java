package tech.wec.iLoveZQW;

public class LongestPalindromicSubstring_5 {
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 0) return "";
            int left = 0, right = 0;
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++){
                int len1 = centerLength(s, i, i);
                int len2 = centerLength(s, i, i + 1);
                maxLen = Math.max(len1, len2);
                if (maxLen > right - left + 1){
                    left = i - (maxLen - 1) / 2;
                    right = i + maxLen / 2;
                }
            }
            return s.substring(left, right + 1);
        }

        private int centerLength(String s, int i, int j){
            while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                i--; j++;
            }
            return j - i - 1;
        }
    }
}
