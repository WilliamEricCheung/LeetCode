package tech.wec.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain_1048 {
    /*
     * DP方法
     * 1. 将单词按照长度升序排列
     * 2. 用HashMap记录当前单词链长度
     * 3. 长度长的单词可以直接接上短的单词，即直接使用已记录的长度，不用再次遍历
     */
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length() - t1.length();
            }
        });
        Map<String, Integer> map = new HashMap<>();
        int res = 1;
        for (String word : words){
            map.put(word, 1);
            for (int i = 0; i < word.length(); i++){
                // 去掉第i个字符
                String subStr = word.substring(0, i) + word.substring(i + 1);
                if (map.containsKey(subStr)){
                    int cnt = map.get(subStr);
                    map.put(word, Math.max(cnt + 1, map.get(word)));
                    res = Math.max(res, cnt + 1);
                }
            }
        }
        return res;
    }
}
