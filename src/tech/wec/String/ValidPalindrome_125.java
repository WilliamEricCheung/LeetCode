package tech.wec.String;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        char left = 0, right = 0;
        for (int l = 0, r = s.length() - 1;l<r;l++,r--){
            while(l<r && !isAlphaOrNumber(left = s.charAt(l)))
                l++;
            while(l<r && !isAlphaOrNumber(right = s.charAt(r)))
                r--;
            if (l>=r)
                return true;
            if (toLowerCase(left)!=toLowerCase(right))
                return false;
        }
        return true;
    }

    private boolean isAlphaOrNumber(char c){
        return (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9');
    }

    private char toLowerCase(char c){
        if (c>='A' && c<='Z'){
            return (char)(c+32);
        }
        return c;
    }
}
