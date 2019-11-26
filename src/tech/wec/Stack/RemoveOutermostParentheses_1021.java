package tech.wec.Stack;

import java.util.Stack;

public class RemoveOutermostParentheses_1021 {

    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int l = 0, r = 0;
        for (int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if (ch == '(') l++;
            else r++;
            if (l == r) {
                sb.append(S.substring(start + 1, i));
                start = i + 1;
            }
        }
        return sb.toString();
    }
}
