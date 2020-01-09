package tech.wec.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses_93 {
    class Solution {

        private List<String> result;
        private LinkedList<String> segments;
        private int n;
        private String s;

        public List<String> restoreIpAddresses(String s) {
            n = s.length();
            this.s = s;
            result = new ArrayList<>();
            segments = new LinkedList<>();
            backtrack(-1, 3);
            return result;
        }

        /**
         * @param prevPos 上一个点的位置
         * @param dots 已经有多少个点了
         */
        private void backtrack(int prevPos, int dots){
            int maxPos = Math.min(n - 1, prevPos + 4);
            for (int cur = prevPos + 1; cur < maxPos; cur++){
                String segment = s.substring(prevPos + 1, cur + 1);
                if (valid(segment)){
                    segments.add(segment);
                    if (dots - 1 == 0) update(cur);
                    else backtrack(cur, dots - 1);
                    segments.removeLast();
                }
            }
        }

        private boolean valid(String segment){
            int len = segment.length();
            if (len > 3) return false;
            return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) < 256) : (len == 1);
        }

        private void update(int curPos){
            String segment = s.substring(curPos + 1, n);
            if (valid(segment)){
                segments.add(segment);
                result.add(String.join(".", segments));
                segments.removeLast();
            }
        }
    }
}
