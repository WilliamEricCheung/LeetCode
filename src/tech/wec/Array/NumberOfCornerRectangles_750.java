package tech.wec.Array;

import java.util.HashMap;
import java.util.Map;

public class NumberOfCornerRectangles_750 {
    class Solution {
        // 利用hash存边角1的坐标，对于循环到的新的对象进行查询
        public int countCornerRectangles(int[][] grid) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int[] rows: grid){
                for (int c1 = 0; c1 < rows.length; c1++) if (rows[c1] == 1){
                    for (int c2 = c1 + 1; c2 < rows.length; c2++) if (rows[c2] == 1){
                        int pos = c1 * 200 + c2; // encode
                        int c = map.getOrDefault(pos, 0);
                        ans += c;
                        map.put(pos, c + 1);
                    }
                }
            }
            return ans;
        }
    }
}
