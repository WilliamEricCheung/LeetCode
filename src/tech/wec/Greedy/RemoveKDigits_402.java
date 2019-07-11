package tech.wec.Greedy;

public class RemoveKDigits_402 {
    public String removeKdigits(String num, int k) {
        if (num == null || k>=num.length())
            return "0";
        StringBuilder sb = new StringBuilder();
        sb.append(num.charAt(0));

        for (int i =1;i<num.length();i++){
            while (k>0 && sb.length()>0 && num.charAt(i)<sb.charAt(sb.length()-1)){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(num.charAt(i));
        }
        while(k-->0)
            sb.deleteCharAt(sb.length()-1);
        while(sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
