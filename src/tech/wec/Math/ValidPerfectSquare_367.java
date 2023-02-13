package tech.wec.Math;

public class ValidPerfectSquare_367 {

    // binary search
    public boolean isPerfectSquare(int num) {
        int start  = 1, end = num;
        while(start <= end){
            int mid = (start + end) >>> 1;
            if (Integer.MAX_VALUE / mid < mid || mid * mid > num)
                end = mid - 1;
            else if (mid * mid == num)
                return true;
            else
                start = mid + 1;
        }
        return false;
    }

    // 改编69题
    public boolean isPerfectSquare_1(int num) {
        if(num <= 1) {
            return true;
        }
        long start = 0, end = num, mid = num / 2;
        while(start < end) {
            long pow = mid * mid;
            if (mid == start) {
                break;
            }
            if (pow < num) {
                start = mid;
            }else if (pow > num) {
                end = mid;
            }else {
                return true;
            }
            mid = start + (end - start) / 2;
        }
        return false;
    }
}
