package tech.wec.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString_1047 {

    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (Character ch: S.toCharArray()){
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != ch)
                sb.append(ch);
            else
                sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
