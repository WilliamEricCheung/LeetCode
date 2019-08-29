package tech.wec.Facebook;

public class DecodeWays_91 {

    // FizzBuzz problem
    public int numDecodings(String s) {
        int sZero = 0; // default state, no previous 1 or 2
        int sOne = 0; // there was 1 before
        int sTwo = 0; // there was 2 before
        int psZero = 1; // previous state, we start from empty string so there is only 1 way to decode it
        int psOne = 0;
        int psTwo = 0;

        for (char ch: s.toCharArray()){
            int value = ch - '0';
            sZero = psOne; // add 1(0-9)
            if (value <= 6)
                sZero += psTwo; // add 2(0-6)
            if (value >= 1)
                sZero += psZero; // normal 1-9
            sOne = 0;
            if (value == 1)
                sOne = psZero; // 1*
            sTwo = 0;
            if (value == 2)
                sTwo = psZero; // 2*
            psZero = sZero;
            psOne = sOne;
            psTwo = sTwo;
        }
        return sZero;
    }

    // DP problem
    public int numDecodings_1(String s){
        if (s==null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int n0 = 1;
        int n1 = 1;
        int len = s.length();
        for (int i = 1;i<len;i++){
            int n2 = 0;
            if (s.charAt(i) != '0')
                n2 += n1;
            int value = Integer.parseInt(s.substring(i-1, i + 1));
            if (value >= 10 && value <= 26)
                n2 += n0;
            n0 = n1;
            n1 = n2;
        }
        return n1;
    }
}
