package tech.wec.Facebook;

/*
Hi all, here I share how you shall tackle this problem at any interview
where the interviewer would say to implement atoi in your preferred language.

You need to come up with requirements, like what type of strings and situations
you need to tackle.

The best way is to write down the test cases while discussing with your interviewer.
This shows that you have a good communication skills. As you see that code is simple,
but this question is asked by many top tier companies, especially in management around
to check on your abilities to code that considers all edge cases.
 */
public class StringToIntegerATOI_8 {
    /**
     Test cases :

     "    12"                | 12
     " 1  2"                 | 1
     " iamthebest 123"       | 0

     "123 iamthebest" 		| 123

     "7648974684949" 			| Inter.MAX_VALUE
     "- 678484"  				| 0
     "-+-.,..---- 1" 			| 0
     "+0" 					| 0
     "-1" 					| -1
     "+    123" 				| 0
     "-  +123"  				| 0
     **/

    // Assumption : first non-empty character has to be valid and subsequent characters are digits
    // No is limited to integer range of values : -2^31 to 2^31 - 1
    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim(); // ignore whitespace
        if (str.length() == 0) return 0; // still nothing
        // find (+) or - symbol
        char symbol = str.charAt(0);;
        boolean isNegative = false;
        if (symbol == '-') isNegative = true;

        long sum = 0;
        for (int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9')
                sum = sum * 10 + (ch - '0');
            else if (i ==0 && (ch == '+' || ch == '-'))
                continue;
            else
                break;
            if (sum <= Integer.MIN_VALUE || sum >= Integer.MAX_VALUE) break;
        }

        if (isNegative)
            sum *= -1;
        if (sum >=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sum <= Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) sum;
    }
}
