package tech.wec.Google;

import java.util.Arrays;

public class HIndex_274 {
    // brute force
    public int hIndex(int[] citations) {
        int max = citations.length;
        boolean isFound = false;
        while(!isFound){
            int cnt = 0;
            for (int i = 0; i < citations.length; i++){
                if (citations[i] >= max)
                    cnt++;
            }
            if (cnt >= max)
                isFound = true;
            else
                max--;
        }
        return max;
    }
    // sorting
    public int hIndex_1(int[] citations){
        Arrays.sort(citations);
        int i = 0;
        while(i < citations.length && citations[citations.length - 1 - i] > i)
            i++;
        return i;
    }

    // counting
    public int hIndex_2(int[] citations){
        int n = citations.length;
        int[] papers = new int[n + 1];
        for (int c : citations)
            papers[Math.min(n, c)]++;
        int ans = n;
        for (int s = papers[n]; ans > s; s += papers[ans])
            ans--;
        return ans;
    }
}
