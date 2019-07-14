package tech.wec.String;

public class ReverseVowelsOfAString_345 {
    public String reverseVowels(String s) {
        int pt = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<s.length();i++){
            if (!isVowels(s.charAt(i)))
                sb.append(s.charAt(i));
            else {
                while(pt >= 0 && !isVowels(s.charAt(pt)))
                    pt--;
                if (pt>=0)
                    sb.append(s.charAt(pt--));
            }
        }
        return sb.toString();
    }

    private boolean isVowels(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            ch += 32;
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
