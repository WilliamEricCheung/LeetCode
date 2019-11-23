package tech.wec.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BasicCalculatorIII_772 {
    public static void main(String[] args) {
        String str = "123 + 1 23";
        str = str.replaceAll("\\s+", "");
        System.out.println(str);
    }
    static class Solution {

        int idx = 0;
        public int calculate(String s) {
            int num = 0, pre = 0, fly = 0;
            char sign = '+';
            while (idx < s.length()) {
                char c = s.charAt(idx++);
                if (c == ' ') continue;
                else if (Character.isDigit(c)) num = num * 10 + c - '0';
                else if (c == '(') num = calculate(s);
                else if (c == ')') break;
                else {
                    if (sign == '*') fly *= num;
                    else if (sign == '/') fly /= num;
                    else if (sign == '+') fly = num;
                    else fly = -num;
                    num = 0;
                    sign = c;
                    if (c == '+' || c == '-') {
                        pre += fly;
                        fly = 0;
                    }
                }
            }
            if (sign == '*') fly *= num;
            else if (sign == '/') fly /= num;
            else if (sign == '+') fly = num;
            else fly = -num;
            return pre + fly;
        }
    }
}
