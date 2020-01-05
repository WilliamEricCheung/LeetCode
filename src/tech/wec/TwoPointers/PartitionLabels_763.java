package tech.wec.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {
    class Solution {

        public List<Integer> partitionLabels(String S) {
            int[] last = new int[26]; // 统计每个字母最后出现的位置
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < S.length(); i++)
                last[S.charAt(i) - 'a'] = i;
            int p = 0, idx = 0;
            for (int i = 0; i < S.length(); i++){
                p = Math.max(p, last[S.charAt(i) - 'a']);
                if (i == p){
                    result.add(i - idx + 1);
                    idx = i + 1;
                }
            }
            return result;
        }
    }
}
