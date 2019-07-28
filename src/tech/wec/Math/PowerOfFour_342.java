package tech.wec.Math;

public class PowerOfFour_342 {

    public boolean isPowerOfFour(int num) {
        return num > 0 && Math.log(num) / Math.log(4) % 1 == 0;
    }
}
