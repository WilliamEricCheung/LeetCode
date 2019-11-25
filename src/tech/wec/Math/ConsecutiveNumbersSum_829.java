package tech.wec.Math;

public class ConsecutiveNumbersSum_829 {

    public int consecutiveNumbersSum(int n) {
        while((n & 1) == 0) n >>= 1;
        int ans = 1, d = 3;
        while(d * d <= n){
            int e = 0;
            while(n % d == 0){
                n /= d;
                e++;
            }
            ans *= e + 1;
            d += 2;
        }
        if (n > 1) ans <<= 1;
        return ans;
    }
}
