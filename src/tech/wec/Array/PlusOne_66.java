package tech.wec.Array;

import java.util.Arrays;

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int [] result = new int[digits.length+1];
        for (int i = 0;i<digits.length;i++){
            result[i+1] = digits[i];
        }
        for (int i=digits.length-1;i>=0;i--){
            if (digits[i]==9) {
                result[i+1] = 0;
                if (i==0)
                    result[0]=1;
            }
            else{
                digits[i]++;
                result[i+1]=digits[i];
                break;
            }
        }
        if(result[0]==0&&result[1]!=0)
            return Arrays.copyOfRange(result, 1, result.length);
        else
            return result;
    }
}
