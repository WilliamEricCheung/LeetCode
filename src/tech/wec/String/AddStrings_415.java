package tech.wec.String;

public class AddStrings_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int n1 = i >= 0 ? num1.charAt(i)- '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j)- '0' : 0;
            int tmp = n1 + n2 + cur;
            cur = 0;
            if (tmp >= 10) {
                cur = tmp / 10;
                sb.insert(0, tmp % 10);
            }
            else
                sb.insert(0, tmp);
        }
        if (cur == 1)
            sb.insert(0,1);
        return sb.toString();
    }
}
