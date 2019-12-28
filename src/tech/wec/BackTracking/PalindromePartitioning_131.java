package tech.wec.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, result, new ArrayList<>(), new StringBuilder(), 0);
        return result;
    }

    private void backtrack(String s, List<List<String>> result, List<String> temp,  StringBuilder sb, int start){
        if (start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++){
            sb.append(s.charAt(i));
            if (!isPalindrome(sb.toString())) continue;
            temp.add(sb.toString());
            backtrack(s, result, temp, new StringBuilder(), i + 1);
            sb = new StringBuilder(temp.remove(temp.size() - 1));
        }
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        return left >= right;
    }
}
