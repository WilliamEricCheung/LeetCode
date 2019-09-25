package tech.wec.Google;

public class SuperEggDrop {
    public int superEggDrop(int K, int N) {
        int low = 1, high = N;
        while(low < high){
            int mid = low + ( high - low) / 2;
            if (f(mid, K, N) < N)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int f(int x, int K, int N){
        int ans = 0, r = 1;
        for (int i = 1; i <= K; ++i){
            r *= x - i + 1;
            r /= i;
            ans += r;
            if (ans >= N)
                break;
        }
        return ans;
    }
}
