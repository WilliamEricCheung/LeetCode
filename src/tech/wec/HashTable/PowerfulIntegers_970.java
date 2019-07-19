package tech.wec.HashTable;

import java.util.ArrayList;
import java.util.List;

public class PowerfulIntegers_970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<>();
        int iUpper = (x==1)? 1: ((int)((double) Math.log(bound)/(double)Math.log(x)));
        int jUpper = (y==1)? 1: ((int)((double) Math.log(bound)/(double)Math.log(y)));
        int sum;
        for (int i=0;i<=iUpper;i++){
            for (int j=0;j<=jUpper;j++){
                sum = (int) (Math.pow(x, i) + Math.pow(y,j));
                if (sum <= bound && !list.contains(sum))
                    list.add(sum);
            }
        }
        return list;
    }
}
