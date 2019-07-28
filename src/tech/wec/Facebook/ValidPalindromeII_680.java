package tech.wec.Facebook;

public class ValidPalindromeII_680 {

    public boolean validPalindrome(String s) {
        for (int i = 0; i<s.length()/2;i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                int j = s.length() -1 -i;
                return isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean isPalindromeRange(String s, int left, int right){
        for (int i = left; i <= left + (right - left) / 2; i++){
            if (s.charAt(i) != s.charAt(right - i + left))
                return false;
        }
        return true;
    }
}
