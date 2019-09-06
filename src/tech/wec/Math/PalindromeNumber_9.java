package tech.wec.Math;

public class PalindromeNumber_9 {
    // O(n) method
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

    // optimized O(log10 n) method
    public boolean isPalindrome_1(int x){
        if (x < 0 || x % 10 == 0 && x != 0)
            return false;
        int reverted = 0;
        while(x > reverted){
            reverted = 10 * reverted + x % 10;
            x = x / 10;
        }
//        if (x == reverted || x == reverted / 10)
//            return true;
//        else
//            return false;
        return x == reverted || x == reverted / 10;
    }
}
