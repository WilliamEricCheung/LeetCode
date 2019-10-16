package tech.wec.Google;

import java.util.TreeMap;

public class OddEvenJump_975 {
    // using TreeMap and Dynamic Programming
    public int oddEvenJumps(int[] a){
        int len = a.length;
        if (len <= 1) return len;
        boolean[] odd = new boolean[len];
        boolean[] even = new boolean[len];
        odd[len - 1] = even[len - 1] = true;

        // key for number, value for idx
        TreeMap<Integer, Integer> vals = new TreeMap<>();
        vals.put(a[len-1], len-1);
        for (int i = -2; i >= 0; i--){
            int v = a[i];
            if (vals.containsKey(v)){
                odd[i] = even[vals.get(v)];
                even[i] = odd[vals.get(v)];
            }else{
                Integer lower = vals.lowerKey(v);
                Integer higher = vals.higherKey(v);

                if (lower != null)
                    even[i] = odd[vals.get(lower)];
                if (higher != null)
                    odd[i] = even[vals.get(higher)];
            }
            vals.put(v, i);
        }
        int ans = 0;
        for (boolean b: odd)
            if (b) ans++;
        return ans;
    }
}
