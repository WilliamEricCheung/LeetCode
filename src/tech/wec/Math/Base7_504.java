package tech.wec.Math;

public class Base7_504 {

    static int[] base = new int[]{5764801, 823543, 117649, 16807, 2401, 343, 49, 7, 1};
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 0){
            num = -num;
            sb.append('-');
        }else if (num == 0)
            return "0";
        for (int i =0;i<9;i++){
            int c = 0;
            while(num >= base[i]){
                num -= base[i];
                c++;
            }
            if (c > 0)
                sb.append(c);
            else{
                if (sb.length()>0 && !sb.toString().equals("-"))
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
