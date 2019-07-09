package tech.wec.Math;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman_12 {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num-1000>=0){
            sb.append("M");
            num -=1000;
        }
        while(num-900>=0){
            sb.append("CM");
            num -= 900;
        }
        while(num-500>=0){
            sb.append("D");
            num -=500;
        }
        while(num-400>=0){
            sb.append("CD");
            num -= 400;
        }
        while(num -100>=0){
            sb.append("C");
            num -= 100;
        }
        while(num - 90 >=0){
            sb.append("XC");
            num -= 90;
        }
        while(num -50 >=0){
            sb.append("L");
            num -= 50;
        }
        while(num -40 >=0){
            sb.append("XL");
            num -= 40;
        }
        while(num - 10 >=0){
            sb.append("X");
            num -= 10;
        }
        while(num -9>=0){
            sb.append("IX");
            num -= 9;
        }
        while(num -5 >=0){
            sb.append("V");
            num -= 5;
        }
        while(num -4 >=0){
            sb.append("IV");
            num -= 4;
        }
        while (num -1>=0){
            sb.append("I");
            num --;
        }
        return sb.toString();
    }
}
