package tech.wec.Math;

public class ConfusingNumber_1056 {
    class Solution {
        public boolean confusingNumber(int N) {
            String n = String.valueOf(N);
            StringBuilder sb = new StringBuilder();
            for (int i = n.length() - 1; i >= 0; i--){
                switch (n.charAt(i)){
                    case '0':
                        sb.append('0');
                        break;
                    case '1':
                        sb.append('1');
                        break;
                    case '6':
                        sb.append('9');
                        break;
                    case '8':
                        sb.append('8');
                        break;
                    case '9':
                        sb.append('6');
                        break;
                    default:
                        return false;
                }
            }
            return Integer.valueOf(sb.toString()) != N;
        }
    }
}
