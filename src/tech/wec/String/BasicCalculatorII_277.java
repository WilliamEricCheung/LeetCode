package tech.wec.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicCalculatorII_277 {
    public int calculate(String s){
        s.replaceAll("\\s+","");
        List<Integer> number = new ArrayList<>();
        List<Character> function = new ArrayList<>();
        int idx = 0;
        while(idx < s.length()){
            if (Character.isDigit(s.charAt(idx))){
                int parser = idx;
                while(parser < s.length() && Character.isDigit(s.charAt(parser)))
                    parser++;
                number.add(Integer.parseInt(s.substring(idx, parser)));
                idx = --parser;
            }
            if (s.charAt(idx) == '/' || s.charAt(idx) == '*' || s.charAt(idx) == '+' || s.charAt(idx) == '-')
                function.add(s.charAt(idx));
            idx++;
        }
        for (int i = 0; i < function.size(); i++){
            if (function.get(i) == '/'){
                int tmp = number.get(i) / number.get(i + 1);
                number.remove(i);
                number.remove(i);
                number.add(i, tmp);
                function.remove(i);
                i--;
            }else if (function.get(i) == '*'){
                int tmp = number.get(i) * number.get(i + 1);
                number.remove(i);
                number.remove(i);
                number.add(i, tmp);
                function.remove(i);
                i--;
            }
        }
        for (int i = 0; i < function.size(); i++){
            if (function.get(i) == '+'){
                int tmp = number.get(i) + number.get(i + 1);
                number.remove(i + 1);
                number.add(i + 1, tmp);
            }else if (function.get(i) == '-'){
                int tmp = number.get(i) - number.get(i + 1);
                number.remove(i + 1);
                number.add(i + 1, tmp);
            }
        }
        return number.get(function.size());
    }
}
