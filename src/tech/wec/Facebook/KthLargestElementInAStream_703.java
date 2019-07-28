package tech.wec.Facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAStream_703 {
    class KthLargest {
        PriorityQueue<Integer> queue;
        private int k;
        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>();
            this.k = k;
            for (int num: nums)
                add(num);
        }

        public int add(int val) {
            queue.add(val);
            if (queue.size() == k + 1){
                queue.remove();
            }
            return queue.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
