package tech.wec.Brainteaser;

public class ExcelSheetColumnNumber_171 {
    public int titleToNumber(String s) {
        int len = s.length();
        int result = 0;
        for (int i = 0; i <len; i++){
            char ch = s.charAt(i);
            result = result * 26 + (int)(ch - 'A' + 1);
        }
        return result;
    }
}
