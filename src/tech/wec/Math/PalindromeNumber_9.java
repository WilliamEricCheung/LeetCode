package tech.wec.Math;

public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        else {
            int tmp = x;
            int reverse = 0;
            while (tmp / 10 > 0) {
                reverse = reverse + tmp % 10;
                tmp = tmp / 10;
                reverse = reverse * 10;
            }
            reverse += tmp;
            if (x == reverse) {
                return true;
            } else {
                return false;
            }
        }
    }
}
