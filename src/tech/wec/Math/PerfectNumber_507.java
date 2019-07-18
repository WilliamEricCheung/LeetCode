package tech.wec.Math;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber_507 {
    // brute force
    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;
        List<Integer> factors = new ArrayList<>();
        factors.add(1);
        for (int i = 2; i <= num / 2 + 1; i++) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        int sum = 0;
        for (Integer i : factors
        ) {
            sum += i;
        }
        return sum == num;
    }

    // optimal method
    public boolean checkPerfectNumber_1(int num) {
        if (num <= 0)
            return false;
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }

            }
        }
        return sum - num == num;
    }
}
