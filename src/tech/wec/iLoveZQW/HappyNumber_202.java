package tech.wec.iLoveZQW;

public class HappyNumber_202 {
    class Solution {
        public boolean isHappy(int n) {
            int sum = 0;
            while(sum!=1){
                sum = 0;
                while(n>=10){
                    int tmp = n % 10;
                    sum += tmp * tmp;
                    n /= 10;
                }
                sum += n * n;
                if (sum == 4 || sum == 16 || sum == 37 || sum == 58|| sum == 89 ||
                        sum == 145 || sum == 42 || sum == 20)
                    return false;
                n = sum;
            }
            return true;
        }
    }
}
