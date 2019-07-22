package tech.wec.BinarySearch;

public class PowXN_50 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        return myPow(x * x, n / 2) * ((n % 2==0)? 1: (n > 0? x : 1/x));
    }
}
