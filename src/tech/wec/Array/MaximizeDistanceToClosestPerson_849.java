package tech.wec.Array;

public class MaximizeDistanceToClosestPerson_849 {
    class Solution {
        // two pointers
        public int maxDistToClosest(int[] seats) {
            if (seats == null || seats.length == 0) return -1;
            int left = -1, right = -1;
            int len = seats.length;
            int dist = 0;
            int idx = 0;
            while(idx < len){
                // for 1
                while(idx < len && seats[idx] == 1)
                    idx++;
                left = idx; // 第一个0
                // for 0
                while(idx < len && seats[idx] == 0)
                    idx++;
                right = idx; // 最后一个0
                if (left == 0 || right == len)
                    dist = Math.max(right - left, dist);
                else
                    dist = Math.max((int)Math.ceil((right - left) / 2.0), dist);
            }
            return dist;
        }
    }
}
