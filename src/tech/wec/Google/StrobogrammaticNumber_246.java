package tech.wec.Google;

public class StrobogrammaticNumber_246 {

    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1;i >= 0; i--){
            char ch = num.charAt(i);
            if (ch == '0' || ch == '1' || ch == '8')
                sb.append(ch);
            else if (ch == '9')
                sb.append('6');
            else if (ch == '6')
                sb.append('9');
            else
                return false;
        }
        return sb.toString().equals(num);
    }
}
