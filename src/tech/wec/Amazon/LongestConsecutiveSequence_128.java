package tech.wec.Amazon;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence_128 {
    // 这里说明了TreeSet存储不是按照输入顺序，而是数值从小到大
    public static void main(String[] args) {
        TreeSet<Integer> test = new TreeSet<>();
        test.add(100);
        test.add(4);
        test.add(200);
        test.add(1);
        test.add(3);
        test.add(2);
        Iterator it = test.iterator();
        while(it.hasNext())
            System.out.println(it.next()+" ");
    }
    // need O(n) time
    // using TreeSet take O(nlogn) time
    public int longestConsecutive_1(int[] nums) {
        if(nums.length <= 1) return nums.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num: nums) set.add(num);
        Iterator it = set.iterator();
        int ans = 1;
        int cur = 1;
        Integer last = (Integer) it.next();
        while(it.hasNext()){
            int now = (Integer) it.next();
            if (last + 1 == now) cur++;
            else cur = 1;
            if (cur > ans)
                ans = cur;
            last = now;
        }
        return ans;
    }

    public int longestConsecutive(int[] nums){
        if(nums.length <= 1) return nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        int ans = 1;
        for (int num: set){
            if (!set.contains(num - 1)){
                int n = num;
                int len = 1;
                while(set.contains(n + 1)){
                    n++;
                    len++;
                }
                if (len > ans) ans = len;
            }
        }
        return ans;
    }
}
