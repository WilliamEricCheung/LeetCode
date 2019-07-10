package tech.wec.DynamicProgramming;

public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        int[] ret = new int[n+1];
        if (n <=3)
            return n;
        else{
            ret[0] = 0;
            ret[1] = 1;
            ret[2] = 2;
            ret[3] = 3;
            for (int i = 4; i <= n; i++) {
                ret[i] = ret[i - 1] + ret[i - 2];
            }
        }
        return ret[n];
    }
}
