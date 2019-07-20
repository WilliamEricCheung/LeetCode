package tech.wec.String;

public class ZigZagConversion_6 {

    /**
     * Row 0: k(2n-2)
     * Row n-1: k(2n-2)+(n-1)
     * Row i: k(2n-2)+i || (k+1)(2n-2)-i
     * k(2n-2) + i
     * ==> Row(i) =
     * (k+1)(2n-2) - i if i !=0 && i != n -1
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int cycle = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < len; j += cycle) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycle - i < len)
                    sb.append(s.charAt(j + cycle - i));
            }
        }
        return sb.toString();
    }
}
