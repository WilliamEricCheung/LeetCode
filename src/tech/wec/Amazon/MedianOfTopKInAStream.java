package tech.wec.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MedianOfTopKInAStream {

    public static void main(String[] args) {
        MedianTopK medianTopK = new MedianTopK(5);
        medianTopK.addInteger(1);
        medianTopK.addInteger(3);
        medianTopK.addInteger(4);
        System.out.println(medianTopK.getMedian());
        medianTopK.addInteger(4);
        System.out.println(medianTopK.getMedian());
    }
    /*Find median of top k in a stream is actually
    find the {k/2 +1 th element}(k is odd) or {k/2th adn k/2 + 1 th element}(k is even)
    just need to keep a queue of k/2+1 th queue. */
    static class MedianTopK{
        private PriorityQueue<Integer> pq;
        private int k;

        public MedianTopK(int k) {
            this.pq = new PriorityQueue<>();
            this.k = k;
        }

        public void addInteger(int num){
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }

        public float getMedian(){
            int size = pq.size();
            List<Integer> list = new ArrayList<Integer>(pq);
            return size % 2 == 0? (float)(list.get(size/2)+list.get(size/2-1))/2.0f: (float)list.get(size/2);
        }
    }
}
