package tech.wec.BinarySearch;

public class MinimizeMaxDistanceToGasStation_774 {
    class Solution {
        // 用二分查找找到可能的最小值
        public double minmaxGasDist(int[] stations, int K) {
            double low = 0, high = 1e8;
            while(high - low > 1e-6){
                double mid = low + (high - low) / 2.0;
                if (possible(mid, stations, K))
                    high = mid;
                else
                    low = mid;
            }
            return low;
        }

        private boolean possible(double d, int[] stations, int K){
            int used = 0;
            for (int i = 0; i < stations.length - 1; i++){
                used += (int)((stations[i+1] - stations[i])/d);
            }
            return used <= K;
        }
    }
}
