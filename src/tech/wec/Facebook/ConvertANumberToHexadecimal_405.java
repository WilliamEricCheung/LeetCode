package tech.wec.Facebook;

public class ConvertANumberToHexadecimal_405 {

    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            int digit= num & 0xf;
            if (digit < 10)
                sb.insert(0, digit);
            else
                sb.insert(0, (char)(digit - 10 + 'a'));
            num >>>=4;
        }
        return sb.toString();
    }
}
