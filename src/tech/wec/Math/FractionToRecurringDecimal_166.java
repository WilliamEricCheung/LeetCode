package tech.wec.Math;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder frac = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) frac.append("-");
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        frac.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) return frac.toString();
        frac.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0){
            if (map.containsKey(remainder)){
                frac.insert(map.get(remainder),"(");
                frac.append(")");
                break;
            }
            map.put(remainder, frac.length());
            remainder *= 10;
            frac.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return frac.toString();
    }
}
