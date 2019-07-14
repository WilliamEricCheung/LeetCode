package tech.wec.String;

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        int cur = 0;
        StringBuilder result = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int ii = i >= 0 ? a.charAt(i) - '0' : 0;
            int jj = j >= 0 ? b.charAt(j) - '0' : 0;
            int tmp = ii + jj + cur;
            cur = 0;
            if (tmp > 1) cur = 1;
            if (tmp == 2 || tmp == 0)
                result.insert(0, '0');
            else
                result.insert(0, '1');
        }
        if (cur == 1)
            result.insert(0, '1');
        return result.toString();
    }
}
