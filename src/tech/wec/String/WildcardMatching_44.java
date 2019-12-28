package tech.wec.String;

public class WildcardMatching_44 {
    class Solution {
        public boolean isMatch(String s, String p) {
            int sLen = s.length(), pLen = p.length();
            int sIdx = 0, pIdx = 0;
            int starIdx = -1, idx = -1;
            while(sIdx < sLen){
                // if the pattern character == string character
                // or pattern character == '?'
                if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))){
                    sIdx++;
                    pIdx++;
                }
                // if pattern character = '*'
                else if (pIdx < pLen && p.charAt(pIdx) == '*'){
                    // check the situation
                    // when '*' matches no characters
                    starIdx = pIdx;
                    idx = sIdx;
                    pIdx++;
                }
                // if pattern character != string character
                // or pattern is used up
                // and there was no '*' character in pattern
                else if (starIdx == - 1) return false;
                else{
                   pIdx = starIdx + 1;
                   sIdx = idx + 1;
                   idx = sIdx;
                }
            }
            // the remaining characters in the pattern should all be '*' characters
            for (int i = pIdx; i < pLen; i++) if (p.charAt(i) != '*') return false;
            return true;
        }
    }
}
