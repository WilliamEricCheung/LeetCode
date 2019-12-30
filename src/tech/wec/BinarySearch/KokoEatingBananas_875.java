package tech.wec.BinarySearch;

public class KokoEatingBananas_875 {
    class Solution {

        public int minEatingSpeed(int[] piles, int H) {
            int low = 1;
            int high = Integer.MAX_VALUE;
            while(low < high){
                int mid = (high - low) / 2 + low;
                if (!canEatAll(piles, H, mid))
                    low = mid + 1;
                else
                    high = mid;
            }
            return low;
        }

        private boolean canEatAll(int[] piles, int h,int k){
            int sum = 0;
            for (int pile: piles){
                sum += (pile - 1) / k + 1;
            }
            return sum <= h;
        }
    }
}
