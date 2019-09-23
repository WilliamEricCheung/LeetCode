package tech.wec.Google;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime_681 {
    // brute force, simulation
    public String nextClosestTime(String time) {
        int cur = 60 * Integer.parseInt(time.substring(0, 2));
        cur += Integer.parseInt(time.substring(3));
        Set<Integer> allowed_digits = new HashSet<>();
        for (char c : time.toCharArray())
            if (c != ':')
                allowed_digits.add(c - '0');
        while (true) {
            cur = (cur + 1) % (24 * 60);
            int[] cur_digits = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            search:
            {
                for (int d : cur_digits) {
                    if (!allowed_digits.contains(d))
                        break search;
                }
                return String.format("%02d:%02d", cur / 60, cur % 60);
            }
        }
    }

    // find time from existed digits
    public String nextClosestTime_1(String time) {
        int cur = 60 * Integer.parseInt(time.substring(0, 2));
        cur += Integer.parseInt(time.substring(3));
        int elapse = 24 * 60;
        int ans = cur;
        Set<Integer> allowed_digits = new HashSet<>();
        for (char c : time.toCharArray())
            if (c != ':')
                allowed_digits.add(c - '0');
        for (int h1 : allowed_digits)
            for (int h2 : allowed_digits) {
                if (h1 * 10 + h2 < 24) {
                    for (int m1 : allowed_digits) {
                        for (int m2 : allowed_digits) {
                            if (m1 * 10 + m2 < 60){
                                int test = (h1 * 10 + h2)* 60 + (m1 * 10 + m2);
                                int interval = Math.floorMod(test - cur, 24 * 60);
                                if (interval > 0 && interval < elapse){
                                    ans = test;
                                    elapse = interval;
                                }
                        }
                    }
                }
            }
        }
        return String.format("%02d:%02d", ans / 60, ans % 60);
    }
}
