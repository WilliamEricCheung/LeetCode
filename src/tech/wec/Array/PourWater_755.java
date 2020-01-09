package tech.wec.Array;

public class PourWater_755 {
    class Solution {
        public int[] pourWater(int[] heights, int v, int k) {
            if (heights.length == 0 || v <= 0 || k < 0 || k >= heights.length) return heights;
            for (int i = 0; i < v; i++){
                int pos = moveLeft(heights, k);
                if (pos < k){
                    heights[pos]++;
                    continue;
                }
                pos = moveRight(heights, k);
                heights[pos]++;
            }
            return heights;
        }

        private int moveLeft(int[] heights, int k){
            int ans = k;
            int left = k - 1;
            while(left >= 0 && heights[left] <= heights[ans]){
                if (heights[left] < heights[ans])
                    ans = left;
                left--;
            }
            return ans;
        }

        private int moveRight(int[] heights, int k){
            int ans = k;
            int right = k + 1;
            while(right < heights.length && heights[right] <= heights[ans]){
                if (heights[right] < heights[ans])
                    ans = right;
                right++;
            }
            return ans;
        }
    }
}
