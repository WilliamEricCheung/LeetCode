package tech.wec.Math;

public class SqrtX_69 {
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }
        long start = 0, end = x, mid = x / 2;
        while(start < end) {
            long pow = mid * mid;
            if (mid == start) {
                break;
            }
            if (pow < x) {
                start = mid;
            }else if (pow > x) {
                end = mid;
            }else {
                return (int)mid;
            }
            mid = start + (end - start) / 2;
        }
        return (int)mid;
    }
}
