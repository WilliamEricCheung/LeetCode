package tech.wec.String;

import java.util.Stack;

public class LicenseKeyFormatting_482 {
    public String licenseKeyFormatting(String S, int K) {
        Stack<Character> stack = new Stack<>();
        S=S.toUpperCase();
        for (char ch : S.toCharArray()){
            if ((ch >= 48 && ch <=57) || (ch >=65 && ch <= 90) ||
                    (ch >= 97 && ch <= 122)) {
                stack.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && stack.size() > K){
            for (int i  = 1; i <= K; i++){
                sb.insert(0, stack.pop());
            }
            sb.insert(0, '-');
        }
        while(!stack.isEmpty())
            sb.insert(0, stack.pop());
        return sb.toString();
    }
}
