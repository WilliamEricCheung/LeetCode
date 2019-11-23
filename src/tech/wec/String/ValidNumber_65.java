package tech.wec.String;

public class ValidNumber_65 {

    public boolean isNumber(String s) {
        boolean hasPoint = false;
        boolean hasE = false;
        boolean hasSign = false;

        String first = "";
        String second = "";
        char[] chars = s.trim().toCharArray();
        for (int i = 0; i < chars.length; i++){
            switch (chars[i]){
                case 'e':
                case 'E':
                    if (hasE || first.isEmpty() || first.equals("."))
                        return false;
                    hasE = true;
                    break;
                case '.':
                    if (hasE || hasPoint)
                        return false;
                    first += '.';
                    hasPoint = true;
                    break;
                case '-':
                case '+':
                    if (hasSign && ! hasE) return false;
                    else if (hasE && !second.isEmpty()) return false;
                    else if (!hasE && !first.isEmpty()) return false;
                    hasSign = true;
                    break;
                default:
                    if (chars[i] >= '0' && chars[i] <= '9'){
                        if (!hasE) first += chars[i];
                        else second += chars[i];
                    }else
                        return false;
                    break;
            }
        }
        if (first.isEmpty() || first.equals(".") || hasE && second.isEmpty() || second.equals("."))
            return false;
        return true;
    }
}
