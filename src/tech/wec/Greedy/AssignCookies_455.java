package tech.wec.Greedy;

import java.util.Arrays;

public class AssignCookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        // 胃口和饼干递增排序
        Arrays.sort(g);
        Arrays.sort(s);
        int curg  = 0;
        int curs = 0;
        int cnt = 0;
        while(curg<g.length && curs<s.length){
            if (g[curg]>s[curs]){
                curs ++;
            }else{
                curg++;
                cnt++;
                curs++;
            }
        }
        return cnt;
    }
}
