package tech.wec.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CampusBikes_1057 {

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int workerNum = workers.length;
        int bikeNum = bikes.length;
        int[] result = new int[workerNum];
        Arrays.fill(result, -1);
        ArrayList<Distance> distances = new ArrayList<>();
        for (int i = 0; i < workerNum; i++){
            int[] worker = workers[i];
            for (int j = 0; j < bikeNum; j++){
                int[] bike = bikes[j];
                int distance = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                distances.add(new Distance(distance, i, j));
            }
        }

        // sort distance
        Collections.sort(distances, (a, b) -> {
            int comp = Integer.compare(a.distance, b.distance);
            if (comp == 0){
                comp = Integer.compare(a.worker, b.worker);
                if (comp == 0)
                    comp = Integer.compare(a.bike, b.bike);
            }
            return comp;
        });

        boolean[] assginedWorker = new boolean[workerNum];
        boolean[] assignedBike = new boolean[bikeNum];
        int cnt = 0;
        for (int i = 0; i < distances.size(); i++){
            if (cnt == workerNum)
                break;
            Distance distance = distances.get(i);
            if (!assginedWorker[distance.worker] && !assignedBike[distance.bike]){
                cnt++;
                assginedWorker[distance.worker] = true;
                assignedBike[distance.bike] = true;
                result[distance.worker] = distance.bike;
            }
        }
        return result;
    }

    class Distance{
        int distance = -1;
        int worker;
        int bike;

        public Distance(int distance, int worker, int bike) {
            this.distance = distance;
            this.worker = worker;
            this.bike = bike;
        }
    }
}
