package tech.wec.Math;

public class AddDigits_258 {

    // return 1+(num-1)%9;
    public int addDigits(int num) {
        if (num <= 9)
            return num;
        StringBuilder str = new StringBuilder();
        str.append(num);
        int tmp = 0;
        for (int i = 0; i < str.length(); i++) {
            tmp += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return addDigits(tmp);
    }
}
