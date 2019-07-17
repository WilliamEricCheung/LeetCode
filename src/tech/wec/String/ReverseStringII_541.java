package tech.wec.String;

public class ReverseStringII_541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        for (int start = 0; start < s.length(); start += 2 * k){
            int left = start, right = Math.min(start + k - 1, s.length() - 1);
            while(left < right){
                char tmp = sb.charAt(left);
                sb.setCharAt(left++, sb.charAt(right));
                sb.setCharAt(right--, tmp);
            }
        }
        return sb.toString();
    }
}
