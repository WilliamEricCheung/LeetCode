package tech.wec.Math;

public class SqrtX_69 {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        long left = 0;
        long right = x;
        long middle;
        while(left<right){
            middle = left + (right - left)/2;
            long time = middle * middle;
            if (middle == left)
                break;
            if (time == x)
                return (int)middle;
            else if (time < x){
                left = middle;
            }else{
                right = middle;
            }
        }
        return (int)left;
    }
}
