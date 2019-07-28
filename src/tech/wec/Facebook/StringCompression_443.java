package tech.wec.Facebook;

public class StringCompression_443 {

    public int compress(char[] chars) {
        int read = 0;
        int write = 0;
        for (int i = 0;i<chars.length;i++){
            if (i+1==chars.length || chars[i+1] != chars[i]){
                chars[write++] = chars[read];
                if (read < i){
                    // trans num to char, like 14 to '1' '4'
                    for (char c: ("" + (i-read+1)).toCharArray())
                        chars[write++] = c;
                }
                read = i + 1;
            }
        }
        return write;
    }
}
