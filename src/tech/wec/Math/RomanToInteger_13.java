package tech.wec.Math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            int tmp = 0;
            if (i + 1 < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                    tmp = 4;
                }
                if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                    tmp = 9;
                }
                if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                    tmp = 40;
                }
                if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                    tmp = 90;
                }
                if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                    tmp = 400;
                }
                if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                    tmp = 900;
                }
                ans += tmp;
                i++;
            } else {
                ans += roman.get(s.charAt(i));
            }
            i++;
        }
        return ans;
    }
}
