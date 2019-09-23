package tech.wec.Google;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestAbsoluteFilePath_388 {

    // 使用spilt对\n分割数组，\t就增加一个level
    public int lengthLongestPath(String input) {
        String[] items = input.split("\n");
        int[] dict = new int[items.length]; // 记录第level的长度
        int level = 0;
        int longest = 0;
        for (String item: items){
            level = count(item, "\t");
            int length = item.length() - level + ((level > 0)? dict[level - 1]:0);
            boolean isFile = item.contains(".");
            if (isFile)
                longest = Math.max(longest, length);
            else
                dict[level] = length + 1; // +1 是为了“/”
        }
        return longest;
    }

    /**
     * 记算pattern在string中出现的次数
     * @param s string
     * @param p pattern
     * @return
     */
    private int count(String s, String p){
        int cnt = 0;
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find())
            cnt++;
        return cnt;
    }

}
