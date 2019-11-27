package tech.wec.HashTable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive_1086 {

    public int[][] highFive(int[][] items) {

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < items.length; i++){
            PriorityQueue<Integer> tmp = map.getOrDefault(items[i][0], new PriorityQueue<>()); // id为i的同学的成绩队列
            tmp.add(items[i][1]);
            if (tmp.size() > 5) tmp.poll();
            map.put(items[i][0], tmp);
        }
        int[][] result = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet()){
            int sum = 0;
            PriorityQueue<Integer> tmp = entry.getValue();
            for (int j = 0; j < 5; j++){
                sum += tmp.poll();
            }
            result[i][0] = entry.getKey();
            result[i][1] = sum / 5;
            i++;
        }
        return result;
    }
}
