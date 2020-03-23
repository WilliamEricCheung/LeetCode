package tech.wec.iLoveZQW;

public class AddBinary_67 {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int rest = 0;
            for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--){
                int num1 = i >= 0? a.charAt(i) - '0': 0;
                int num2 = j >= 0? b.charAt(j) - '0': 0;
                int total = rest + num1 + num2;
                if (total >= 2){
                    rest = total / 2;
                    sb.insert(0, total % 2);
                }else{
                    rest = 0;
                    sb.insert(0, total % 2);
                }
            }
            if (rest == 1)
                sb.insert(0, "1");
            return sb.toString();
        }
    }
}
