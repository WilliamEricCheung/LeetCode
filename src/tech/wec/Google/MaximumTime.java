package tech.wec.Google;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaximumTime {
    public static void main(String[] args){
        System.out.println(maxTime("?4:5?")+isValidTime("?4:5?"));
        System.out.println(maxTime("23:5?") + isValidTime("23:5?"));
        System.out.println(maxTime("2?:22") + isValidTime("2?:22"));
        System.out.println(maxTime("0?:??") + isValidTime("0?:??"));
        System.out.println(maxTime("??:??") + isValidTime("??:??"));
        System.out.println(isValidTime("111:1"));
    }

    public static String maxTime(String T){

        char[] time = T.toCharArray(), result = "23:59".toCharArray(); // is used to get hour, minute is not constraint by the time format.
        result[0] = time[1]!='?' && time[1] > '3'? '1':result[0]; // if hour is format like '04' or '?4' which means first digit is '0' or '1'
        result[1] = time[0]!='?' && time[0] < '2'? '9':result[1]; // if hour is format like '0?' or '23' which measn second digit is '9' or '3'
        for (int i = 0; i <time.length; i++){
            result[i] = time[i] != '?' ? time[i] : result[i];  // replace '?'
        }
        return String.valueOf(result);
    }

    private static boolean isValidTime(String T){
        if (T.length() != 5)
            return false;
        Pattern p = Pattern.compile("[0-2?][0-9?]:[0-5?][0-9?]");
        Matcher m = p.matcher(T);
        boolean flag = true;
        if (T.charAt(0) == '2' && T.charAt(1) > '3' && T.charAt(1)!='?')
            flag = false;
        if (T.isEmpty() || !m.matches() || !flag){
            return false;
        }
        return true;
    }
}
