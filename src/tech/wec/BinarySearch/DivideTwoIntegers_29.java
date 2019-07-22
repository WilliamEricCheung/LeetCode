package tech.wec.BinarySearch;

public class DivideTwoIntegers_29 {

    public int divide(int dividend, int divisor) {
        if (dividend == 0 && divisor == -1)
            return dividend;
        if (divisor == -1)
            return (dividend ==Integer.MIN_VALUE)? Integer.MAX_VALUE : 0 - dividend;
        // to figure out the sign of result
        boolean flag = (dividend >=0 && divisor > 0) || (dividend <0 && divisor < 0);
        dividend = (dividend > 0)? 0-dividend:dividend;
        divisor = (divisor > 0)? 0-divisor:divisor;

        long ans = helper(dividend, divisor);
        ans = flag? ans: 0-ans;
        return (int) ans;
    }

    public long helper(long x, long y){
        if (x > y)
            return 0;
        long ans = 1;
        long z = y;
        while(z + z > x){
            ans += ans;
            z += z;
        }

        return ans + helper(x- z, y);
    }
}
