package tech.wec.Math;

public class CountPrimes_204 {
    public int countPrimes(int n) {
        if (n<=2)
            return 0;
        else if (n == 3)
            return 1;
        int r = n - 2;
        for (int i = 4;i<n;i++){
            for (int j = 2;j<=i/j;j++){
                if (i % j == 0) {
                    r--;
                    break;
                }
            }
        }
        return r;
    }
}
