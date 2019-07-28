package tech.wec.Facebook;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaximumNumber_414 {

    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int num : nums){
            if (num > first){
                third = second;
                second = first;
                first = num;
            }
            if (num > second && num < first){
                third = second;
                second = num;
            }
            if (num > third && num < second){
                third = num;
            }
        }
        return (int)(third == Long.MIN_VALUE || third == second ? first : third);
    }

    public int thirdMax_1(int[] nums){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            if (!set.contains(num)){
                heap.add(num);
                set.add(num);
            }
            if (heap.size()>3)
                heap.remove();
        }
        if (heap.size()<3){
            int max= 0;
            while (!heap.isEmpty()){
                max = heap.remove();
            }
            return max;
        }
        return heap.peek();
    }
}
