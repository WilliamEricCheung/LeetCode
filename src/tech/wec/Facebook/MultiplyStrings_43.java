package tech.wec.Facebook;

import java.util.Arrays;

public class MultiplyStrings_43 {

    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0)
            return "0";

        int n1 = num1.length();
        int n2 = num2.length();

        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        char[] result = new char[n1 + n2];
        Arrays.fill(result, '0');

        for (int i= n1-1;i>=0;i--){
            for (int j = n2-1;j>=0;j--){
                int prod = (s1[i] - '0') * (s2[j] - '0');
                int temp = result[i+j+1] - '0' + prod;
                result[i+j+1] = (char)(temp % 10 + '0');
                result[i+j] = (char)(result[i+j] - '0' + (temp/10 + '0'));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char x: result)
            sb.append(x);
        String res = sb.toString();
        while(res.charAt(0) == '0'){
            if (res.length() == 1 && res.equals("0"))
                return "0";
            res = res.substring(1);
        }
        return sb.toString();
    }
}
