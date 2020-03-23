package tech.wec.iLoveZQW;

public class ValidPalindrome_125 {
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.strip();
            int left = 0, right = s.length() - 1;
            for (;left < right; left++, right--){
                while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
                while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
                if(left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                    return false;
            }
            return true;
        }
    }
}
