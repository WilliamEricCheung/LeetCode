package tech.wec.DivideAndConquer;

import java.util.HashMap;
import java.util.Map;

public class BeautifulArray_932 {
    //  (A[i] - A[k]) / (A[k] - A[i]) != 1
    Map<Integer, int[]> map = new HashMap<>();
    public int[] beautifulArray(int N) {
        return devide(N);
    }

    private int[] devide(int N){
        if (map.containsKey(N))
            return map.get(N);
        int[] ans = new int[N];
        if (N == 1)
            ans[0] = 1;
        else{
            int t = 0;
            for (int x: devide((N+1)/2)) //left all odds
                ans[t++] = 2 * x - 1;
            for (int x: devide(N/2)) //right all even
                ans[t++] = 2 * x;
        }
        map.put(N, ans);
        return ans;
    }
}
