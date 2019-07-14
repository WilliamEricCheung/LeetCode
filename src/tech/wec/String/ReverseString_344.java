package tech.wec.String;

public class ReverseString_344 {
    public void reverseString(char[] s) {
        int left= 0;
        int right = s.length - 1;
        while(left < right){
            char ch = s[right];
            s[right] = s[left];
            s[left] = ch;
            right--;
            left++;
        }
    }
}
