package tech.wec.Sort;

public class MaxChunksToMakeSorted_769 {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int max = 0;
            int cnt = 0;
            for (int i = 0; i<arr.length; i++){
                max = Math.max(max, arr[i]);
                if (i == max) cnt++;
            }
            return cnt;
        }
    }
}
