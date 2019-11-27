package tech.wec.Array;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray_697 {

    class Location{
        int freq;
        int first;
        int last;

        public Location(int freq, int first, int last) {
            this.freq = freq;
            this.first = first;
            this.last = last;
        }
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Location> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                Location loc = map.get(nums[i]);
                loc.last = i;
                loc.freq++;
                map.put(nums[i], loc);
            }else{
                Location loc = new Location(1, i, i);
                map.put(nums[i], loc);
            }
        }
        int degree = 0;
        for (Map.Entry<Integer, Location> entry: map.entrySet()){
            if (entry.getValue().freq > degree)
                degree = entry.getValue().freq;
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Location> entry: map.entrySet()){
            if (entry.getValue().freq == degree)
                ans = Math.min(ans, entry.getValue().last - entry.getValue().first + 1);
        }
        return ans;
    }
}
