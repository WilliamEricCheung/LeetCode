package tech.wec.BitManipulation;

public class HammingDistance_461 {
    public int hammingDistance(int x, int y) {
        int ans = x ^ y;
        int cnt = 0;
        while (ans / 2 != 0 && ans != 1) {
            if (ans % 2 != 0)
                cnt++;
            ans /= 2;
        }
        if (ans == 1)
            cnt++;
        return cnt;
    }
}
