package tech.wec.iLoveZQW;

public class AddStrings_415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int rest = 0;
            for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0;i--, j--){
                int n1 = i >= 0? num1.charAt(i) - '0': 0;
                int n2 = j >= 0? num2.charAt(j) - '0': 0;
                int add = n1 + n2 + rest;
                rest = 0;
                if (add >= 10){
                    rest = add / 10;
                    sb.insert(0, add % 10);
                }else sb.insert(0, add);
            }
            if (rest == 1)
                sb.insert(0, 1);
            return sb.toString();
        }
    }
}
