package tech.wec.Stack;

public class MinimumRemoveToMakeValidParentheses_1249 {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            StringBuilder sb = new StringBuilder();
            int open = 0;
            int balance = 0;
            // Parse 1: Remove all invalid ")"
            for (int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if (ch == '('){
                    open++; balance++;
                }else if (ch == ')'){
                    if (balance == 0) continue; // remove
                    balance--;
                }
                sb.append(ch);
            }

            StringBuilder result = new StringBuilder();
            int keep = open - balance;
            for (int i = 0; i < sb.length(); i++){
                char ch = sb.charAt(i);
                if (ch == '('){
                    keep--;
                    if (keep < 0) continue;
                }
                result.append(ch);
            }
            return result.toString();
        }
    }
}
