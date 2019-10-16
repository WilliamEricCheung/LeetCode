package tech.wec.Google;

public class MaximumTime {
    public static void main(String[] args){
        System.out.println(maxTime("?4:5?"));
        System.out.println(maxTime("23:5?"));
        System.out.println(maxTime("2?:22"));
        System.out.println(maxTime("0?:??"));
        System.out.println(maxTime("??:??"));
    }

    public static String maxTime(String time){
        char[] cTime = time.toCharArray(), result = "23:59".toCharArray();
        result[0] = cTime[1]!='?' && cTime[1] > '3'? '1':result[0];
        result[1] = cTime[0]!='?' && cTime[0] < '2'? '9':result[1];
        for (int i = 0; i <cTime.length; i++){
            result[i] = cTime[i] != '?' ? cTime[i] : result[i];
        }
        return String.valueOf(result);
    }
}
