package tech.wec.String;

import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 {
    public static void main(String[] args) {
        String[] words = {"what", "must","be","acknowledgment","shall","be("};
        List<String> result = fullJustify(words, 16);
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }

    static public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int length = 0; // 统计当前行词汇长度，不含空格
        int ptr = 0; // 每行的第一个词汇位置
        for (int i = 0; i < words.length; i++) {
            // 超过了一行的长度，搞个新行
            if (length + words[i].length() + i - ptr > maxWidth) {
                StringBuilder sb = new StringBuilder();
                // 安排当前行的字符串构成
                // [ptr, i)为当前行的词汇index
                int space = maxWidth - length; // 空格总数
                int used = i - ptr - 1; // 每个词之间至少用去的1个空格总数
                if(used != 0){
                    int base = space / used; // 每个词之间基本的间隔
                    int add = space % used; // 前add个词多一个空格
                    for (int idx = 0; idx < i - ptr; idx++) {
                        if (idx < add) {
                            sb.append(words[ptr + idx]);
                            // 加空格
                            for (int j = 0; j < base; j++) {
                                sb.append(" ");
                            }
                            // 多加个空格
                            sb.append(" ");
                        } else {
                            // 正常添加空格
                            if (idx == i - ptr - 1) { // 最后一个词b不需要空格
                                sb.append(words[i - 1]);
                            } else {
                                sb.append(words[ptr + idx]);
                                for (int j = 0; j < base; j++)
                                    sb.append(" ");
                            }
                        }
                    }
                    result.add(sb.toString()); // 保存当前行
                }else{
                    sb.append(words[ptr]);
                    int len = sb.length();
                    for (int j = len; j < maxWidth; j++)
                        sb.append(" ");
                    result.add(sb.toString());
                }
                length = words[i].length(); // 长度
                ptr = i; // 第i个词为首做新行
            }
            else
                length += words[i].length();
            // 如果是最后一行
            if (i == words.length - 1) {
                StringBuilder sb = new StringBuilder();
                for (int idx = ptr; idx < i; idx++) {
                    sb.append(words[idx] + " ");
                }
                sb.append(words[i]);
                int len = sb.length();
                for (int j = len; j < maxWidth; j++)
                    sb.append(" ");
                result.add(sb.toString());
            }
        }
        return result;
    }
}
