package tech.wec.Google;

import java.util.Arrays;

public class MinNumberOfChairs {
    public static void main(String[] args) {
        int[] S = new int[]{1,2,6,5,3};
        int[] E = new int[]{5,5,7,6,8};
        System.out.println(minNumber(S, E));
    }

    public static int minNumber(int[] start, int[] end){
        Arrays.sort(start);
        Arrays.sort(end);
        int startPtr = 0, endPtr = 0;
        int ans = 0;
        int n = start.length;
        while(startPtr < n){
            if (start[startPtr] >= end[endPtr]){
                ans--;
                endPtr++;
            }
            ans++;
            startPtr++;
        }
        return ans;
    }
}
