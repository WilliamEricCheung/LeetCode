package tech.wec.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {

    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if (len % 2 != 0)
            return false;
        else{
            for (int i =0;i<s.length();i++){
                char ch = s.charAt(i);
                if (map.containsKey(ch))
                    stack.push(map.get(ch));
                else if (map.containsValue(ch)){
                    if (stack.empty() || stack.pop() != ch)
                        return false;
                }
            }
        }
        return stack.empty();
    }
}
