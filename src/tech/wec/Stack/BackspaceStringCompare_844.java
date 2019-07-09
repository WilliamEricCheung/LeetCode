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
}
