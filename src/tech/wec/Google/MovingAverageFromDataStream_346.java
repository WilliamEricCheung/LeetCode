package tech.wec.Google;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingAverageFromDataStream_346 {

    static class MovingAverage {

        private Queue<Integer> nums = new LinkedList<>();
        private int window = 0; // window size
        private double sum = 0.0;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.window = size;
        }

        public double next(int val) {
            if (nums.size() < window){
                sum += val;
                nums.offer(val);
                return sum / nums.size();
            }else{
                sum -= nums.poll();
                sum += val;
                nums.offer(val);
                return sum / nums.size();
            }
        }

    }
}
