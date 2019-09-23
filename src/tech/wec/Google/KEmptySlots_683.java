package tech.wec.Google;

import java.util.TreeSet;

public class KEmptySlots_683 {
    // using TreeSet
    public int kEmptySlots(int[] bulbs, int K) {
        TreeSet<Integer> active = new TreeSet<>();
        int day = 0;
        for (int bulb: bulbs){
            day++;
            active.add(bulb);
            Integer lower = active.lower(bulb);
            Integer higher = active.higher(bulb);
            if (lower != null && bulb - lower - 1 == K ||
            higher != null && higher - bulb - 1 == K)
                return day;
        }
        return -1;
    }
}
