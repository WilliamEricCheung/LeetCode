package tech.wec.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_17 {

    static Map<String, String> map = new HashMap<>();
    static{
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
    }

    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            combine("", digits);
        return ans;
    }

    private void combine(String str, String next){
        if (next.length() == 0)
            ans.add(str);
        else{
            String digit = next.substring(0,1);
            String letters = map.get(digit);
            for (int i =0;i<letters.length();i++){
                String letter = String.valueOf(letters.charAt(i));
                combine(str + letter, next.substring(1));
            }
        }
    }
}
