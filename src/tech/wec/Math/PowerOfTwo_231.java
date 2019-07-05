package tech.wec.Math;

public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        return  (n & (n-1))==0 && n != 0 && n != Integer.MIN_VALUE;
    }
}
