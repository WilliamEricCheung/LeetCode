package tech.wec.Google;

public class SentenceScreenFitting_418 {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int rest = cols; // calculate rest col numbers
        int needed = 1; // calculate needed rows
        int circle = 0; // calculate how many times
        while(needed < rows) {
            for (int i = 0; i< sentence.length;i++) {
                int len = sentence[i].length();
                if (len > cols)
                    return 0;
                else if (len > rest) {
                    needed++;
                    rest = cols - len - 1;
                } else
                    rest = rest - len - 1;
                if (rest <= 0) {
                    needed++;
                    rest = cols;
                }
                if (needed > rows && i < sentence.length - 1){
                    circle--;
                    break;
                }
            }
            circle++;
        }
        return circle;
    }

    // best
    public int wordsTyping_1(String[] sentence, int rows, int cols) {
        int res = 0, n = sentence.length;
        int[] dp = new int[n];
        int curLeft = cols + 1, k = 0;
        // Initialization for dp[0], add a "virtual" space padding before each line
        while (curLeft >= sentence[k % n].length() + 1) {
            curLeft -= (sentence[k % n].length() + 1);
            k++;
        }
        dp[0] = k;
        // Fill the value for dp[i], i = 1, 2, 3, ... , n-1
        for (int i = 1; i < n; i++) {
            if (k - i > -1) {
                curLeft += (sentence[i - 1].length() + 1);
            }
            while (curLeft >= sentence[k % n].length() + 1) {
                curLeft -= (sentence[k % n].length() + 1);
                k++;
            }
            dp[i] = k - i;
        }
        int nextStart = 0;
        // Fill the string line by line and calculate the cumulative number of strings
        for (int i = 0; i < rows; i++) {
            res += dp[nextStart];
            nextStart = (nextStart + dp[nextStart]) % n;
        }
        return res / n;
    }
}
