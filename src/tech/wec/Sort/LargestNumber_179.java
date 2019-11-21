package tech.wec.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber_179 {
    public String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num: nums)
            list.add(num);
        Collections.sort(list, (a, b) ->{
            String o1 = a.toString() + b.toString();
            String o2 = b.toString() + a.toString();
            return o2.compareTo(o1);
        });
        StringBuilder sb = new StringBuilder();
        for (Integer i: list){
            sb.append(i);
        }
        // 去除多余的0
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
