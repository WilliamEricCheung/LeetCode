package tech.wec.iLoveZQW;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {

    class Solution {
        public boolean isValid(String s) {
            if (s.equals("")) return true;
            Map<Character, Character> map = new HashMap<>();
            map.put('(',')');
            map.put('[',']');
            map.put('{','}');
            Stack<Character> stack = new Stack<>();
            int len = s.length();
            if (len % 2 != 0)
                return false;
            else{
                for (int i =0;i<len;i++){
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
}
