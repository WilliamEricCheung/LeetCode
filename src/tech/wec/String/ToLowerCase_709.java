package tech.wec.String;

public class ToLowerCase_709 {

    // please read source code carefully
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }
    /**
     public String toLowerCase(Locale locale) {
     if (locale == null) {
     throw new NullPointerException();
     }

     int firstUpper;
     final int len = value.length;
     // Now check if there are any characters that need to be changed.
    scan: {
        for (firstUpper = 0 ; firstUpper < len; ) {
            char c = value[firstUpper];
            if ((c >= Character.MIN_HIGH_SURROGATE)
                    && (c <= Character.MAX_HIGH_SURROGATE)) {
                int supplChar = codePointAt(firstUpper);
                if (supplChar != Character.toLowerCase(supplChar)) {
                    break scan;
                }
                firstUpper += Character.charCount(supplChar);
            } else {
                if (c != Character.toLowerCase(c)) {
                    break scan;
                }
                firstUpper++;
            }
        }
        return this;
    }
     */
}
