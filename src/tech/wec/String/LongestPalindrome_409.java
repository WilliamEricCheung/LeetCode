package tech.wec.String;

public class LongestPalindrome_409 {

    public int longestPalindrome(String s) {
        int[] dictionary  = new int[58];
        for (int i = 0;i<s.length();i++){
            dictionary[s.charAt(i)-'A']++;
        }
        int result = 0;
        for (int i =0;i<58;i++){
            result += dictionary[i] / 2 * 2;
            if (result % 2 == 0 && dictionary[i] % 2 == 1)
                result++;
        }
        return result;
    }
}
