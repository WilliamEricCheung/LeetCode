package tech.wec.Stack;

import java.util.Stack;

public class BackspaceStringCompare_844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = stringHelper(S);
        Stack<Character> t = stringHelper(T);
        while(!s.empty() && !t.empty()){
            if (s.pop() != t.pop())
                return false;
        }
        if (s.empty() && !t.empty() || !s.empty() && t.empty())
            return false;
        return true;
    }

    private Stack<Character> stringHelper(String str){
        Stack<Character> stack = new Stack<>();
        for (int i =0;i<str.length();i++){
            if (str.charAt(i)=='#'){
                if (!stack.empty())
                    stack.pop();
            }else{
                stack.push(str.charAt(i));
            }
        }
        return stack;
    }

//    public boolean backspaceCompare(String s, String t) {
//        return backspaceString(s).equals(backspaceString(t));
//    }
//
//    public String backspaceString(String str) {
//        int len = 0;
//        StringBuffer sb = new StringBuffer();
//        for(int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            if(ch == '#' && sb.length() > 0) {
//                sb.deleteCharAt(--len);
//            }else if(ch == '#' && sb.length() == 0){
//                continue;
//            }else{
//                sb.append(ch);
//                len++;
//            }
//        }
//        return sb.toString();
//    }
}
