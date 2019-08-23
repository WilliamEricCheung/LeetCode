package tech.wec.String;

public class RepeatedSubstringPattern_459 {

    public boolean isRepeated(String s, int len){
        int ptr = 0;
        int strLen = s.length();
        while(ptr + len < strLen){
            if (s.charAt(ptr) != s.charAt(ptr + len))
                return false;
            ptr++;
        }
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length() / 2;
        int strLen = s.length();
        while(len > 0){
            while(strLen % len != 0) len--;
            if (isRepeated(s, len))
                return true;
            len--;
        }
        return false;
    }
}
