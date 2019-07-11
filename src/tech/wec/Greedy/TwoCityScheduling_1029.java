package tech.wec.Greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoCityScheduling_1029 {

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int cityANum = 0;
        int cityBNum = 0;
        int costSum = 0;
        Person[] people = new Person[2 * n];

        // greedy first
        for (int i = 0; i < 2 * n; i++) {
            int[] cost = costs[i];
            people[i] = new Person(cost);
            int price = Math.min(cost[0], cost[1]);
            if (cost[0] == price)
                cityANum++;
            else
                cityBNum++;
            costSum += price;
        }

        // sort A and B's price difference
        Arrays.sort(people);

        // find smallest difference, and add difference to cost sum
        for (int i = 0;i<people.length && cityANum!=cityBNum; i++){
            if (cityANum > cityBNum && people[i].city == 'A'){
                costSum += people[i].diff;
                cityANum--; cityBNum++;
            }
            if (cityANum <cityBNum && people[i].city == 'B'){
                costSum +=people[i].diff;
                cityANum++;cityBNum--;
            }
        }
        return costSum;
    }

    class Person implements Comparable<Person> {

        private int cityA;
        private int cityB;
        private int diff;
        private char city;

        public Person(int[] cost) {
            this.cityA = cost[0];
            this.cityB = cost[1];
            this.diff = Math.abs(cost[0] - cost[1]);
            this.city = cityA <= cityB ? 'A' : 'B';
        }

        /**
         * 返回正数,代表前面的比后面的大
         * 返回0,代表前后相等
         * 返回负数,代表前面的比后面的小
         * 此处按照diff升序排序
         * @param o
         * @return
         */
        @Override
        public int compareTo(Person o) {
            if (this.diff < o.diff)
                return -1;
            else if (this.diff == o.diff)
                return 0;
            else
                return 1;
        }
    }
}
