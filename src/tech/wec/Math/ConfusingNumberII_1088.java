package tech.wec.Math;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumberII_1088 {
    class Solution {
        // 递归求解 dfs
        private int result;
        private Map<Integer, Integer> keyMap = new HashMap<>();
        public int confusingNumberII(int N) {
            result = 0;
            keyMap.put(0, 0);
            keyMap.put(1, 1);
            keyMap.put(6, 9);
            keyMap.put(8, 8);
            keyMap.put(9, 6);
            dfs(N, 0);
            return result;
        }

        /**
         * dfs
         * @param N 上限
         * @param cur 当前递归到的以cur开头的数字
         */
        private void dfs(int N, long cur){
            if (confusingNumber(cur)) result++;
            for (Integer i: keyMap.keySet()){
                if (cur * 10 + i <= N && cur * 10 + i != 0)
                    dfs(N, cur * 10 + i);
            }
        }

        private boolean confusingNumber(long N) {
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
