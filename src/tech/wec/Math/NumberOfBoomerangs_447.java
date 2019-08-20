package tech.wec.Math;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs_447 {

    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int ans = 0;
        for (int i =0;i<len;i++) {
            // key for distance, value for candidates
            Map<Integer, Integer> map = new HashMap();
            for (int j = 0;j<len;j++){
                if (i == j) continue;
                int distance = getDistanceSquare(points[i], points[j]);
                map.put(distance, (map.getOrDefault(distance, 0) + 1));
            }
            for (int cand : map.values())
                ans += cand * (cand - 1);
        }
        return ans;
    }

    private int getDistanceSquare(int[] a, int[] b){
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x * x + y * y;
    }
}
