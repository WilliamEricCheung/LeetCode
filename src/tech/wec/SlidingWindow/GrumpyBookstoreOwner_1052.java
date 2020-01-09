package tech.wec.SlidingWindow;

public class GrumpyBookstoreOwner_1052 {
    class Solution {
        // sliding window
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            int presum = 0;
            for (int i = 0; i < customers.length; i++){
                if (grumpy[i] == 0)
                    presum += customers[i];
            }
            int winsum = 0;
            for (int i = 0; i < X; i++){
                if (grumpy[i] == 1)
                    winsum += customers[i];
            }
            winsum += presum;
            int max = winsum;
            for (int i = X; i < customers.length; i++){
                if (grumpy[i - X] == 1)
                    winsum -= customers[i - X];
                if (grumpy[i] == 1)
                    winsum += customers[i];
                if (max < winsum)
                    max = winsum;
            }
            return max;
        }
    }
}
