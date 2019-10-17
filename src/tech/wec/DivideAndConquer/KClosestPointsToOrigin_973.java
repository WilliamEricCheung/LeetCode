package tech.wec.DivideAndConquer;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin_973 {
    public int[][] kClosest_1(int[][] points, int K) {
        int len = points.length;
        int[] dists = new int[len];
        for (int i =0;i<len;i++)
            dists[i] = distance(points[i]);
        Arrays.sort(dists);
        int[][] ans = new int[K][2];
        int t = 0;
        for (int i= 0;i<len;i++)
            if (distance(points[i]) <= dists[K-1])
                ans[t++] = points[i];
        return ans;
    }

    private int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosest(int[][] points, int K){
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return (ints[0] * ints[0] + ints[1] * ints[1]) - (t1[0] * t1[0] + t1[1]*t1[1]);
            }
        });
        return Arrays.copyOfRange(points,0, K);
    }
}
