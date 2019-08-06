package tech.wec.Brainteaser;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows_299 {

    public String getHint(String secret, String guess) {
        int len = secret.length();
        int bull = 0, cow = 0;
        int[] secret_digit_count = new int[10];
        int[] guess_digit_count = new int[10];
        for (int i = 0;i<len;i++){
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            }
            else{
                secret_digit_count[secret.charAt(i)-'0']++;
                guess_digit_count[guess.charAt(i)-'0']++;
            }
        }
        for (int i =0;i<10;i++)
            cow += Math.min(secret_digit_count[i], guess_digit_count[i]);
        return bull + "A"+cow+"B";
    }
}
