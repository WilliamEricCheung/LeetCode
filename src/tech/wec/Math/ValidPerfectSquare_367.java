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
}
