package tech.wec.Google;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings_271 {
     class Codec {

         // Encodes string length to bytes string
         public String intToString(String str){
             int len = str.length();
             char[] bytes = new char[4];
             for (int i = 3; i >= 0; i--){
                 bytes[3 - i] = (char) (len >> (i * 8) & 0xff);
             }
             return new String(bytes);
         }

         // Deocdes bytes string to integer
         public int stringToInt(String str){
             int result = 0;
             for (char b : str.toCharArray())
                 result = (result << 8) + (int)b;
             return result;
         }

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String str : strs){
                sb.append(intToString(str));
                sb.append(str);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            int i = 0, n = s.length();
            List<String> result = new ArrayList<>();
            while(i < n){
                int length = stringToInt(s.substring(i, i+ 4));
                i += 4;
                result.add(s.substring(i, i+ length));
                i += length;
            }
            return result;
        }
    }
}
