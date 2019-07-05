package tech.wec.Math;

public class FactorialTrailingZeroes_172 {
    public int trailingZeroes(int n) {
        long five = 5;
        int cnt = 0;
        while(five <= n){
            cnt += n / five;
            five *= 5;
        }
        return cnt;
    }
}
