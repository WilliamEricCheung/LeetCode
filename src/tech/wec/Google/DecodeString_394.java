package tech.wec.Google;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString_394 {

    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        Deque<Object> deque = new LinkedList<>();
        int num = 0;
        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                num = 10 * num + (ch - '0');
            } else if (ch == '['){
                deque.push(num);
                num = 0;
            } else if (ch == ']'){
                deque.push(popString(deque));
            }else{
                deque.push(String.valueOf(ch));
            }
        }
        return popString(deque);
    }

    private String popString(Deque<Object> s){
        StringBuilder sb = new StringBuilder();
        Integer num = 1;
        while(!s.isEmpty() && s.peek() instanceof String)
            sb.insert(0, s.pop());
        if (s.peek() instanceof  Integer)
            num = (Integer) s.pop();
        String result = "";
        for (int i = 0; i < num; i++)
            result += sb.toString();
        return result;
    }
}
