package tech.wec.Facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses_301 {

    private Set<String> validExpression = new HashSet<>();
    private int minimumRemoved;
    private void reset(){
        this.validExpression.clear();
        this.minimumRemoved = Integer.MAX_VALUE;
    }
    private void recurse(String s, int index, int leftCount, int rightCount,
                         StringBuilder expression, int removedCount){
        // if we have reached the end of string
        if(index == s.length()){
            // if the current expression is valid
            if (leftCount == rightCount){
                // if the current count of removed parenthesis is <= the current minimum count
                if (removedCount <= this.minimumRemoved){
                    String possibleAnswer = expression.toString();
                    // if the current count beats the overall minimum we have till now
                    if (removedCount < this.minimumRemoved){
                        this.validExpression.clear();
                        this.minimumRemoved = removedCount;
                    }
                    this.validExpression.add(possibleAnswer);
                }
            }
        }else {
            char currentCharacter = s.charAt(index);
            int length = expression.length();
            // if the current character is neither an opening bracket nor a closing one,
            // simply recurse further by adding it to the expression StringBuilder
            if (currentCharacter != '(' && currentCharacter!=')'){
                expression.append(currentCharacter);
                this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
                expression.deleteCharAt(length);
            }else{
                // recursion where we delete the current character and move forward
                this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
                expression.append(currentCharacter);
                // if it is an opening parenthesis, consider it and recurse
                if (currentCharacter == '('){
                    this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                }else if (rightCount < leftCount){
                    // for a closing parenthesis, only recurse if right < left
                    this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                }
                expression.deleteCharAt(length);
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        this.reset();
        this.recurse(s,0,0,0, new StringBuilder(), 0);
        return new ArrayList<>(this.validExpression);
    }
}
