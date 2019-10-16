package tech.wec.Google;

public class WateringFlowers {
    public static void main(String[] args) {
        int[] plants = new int[]{2,4,5,1,2};
        System.out.println(solution(plants,5,7));
    }

    public static int solution(int[] plants, int capacity1, int capacity2){
        int remain1 = 0;
        int remain2 = 0;
        int left = 0;
        int right = plants.length - 1;
        int refills = 0;
        while(left < right){
            if (remain1 < plants[left]){
                remain1 = capacity1;
                refills++;
            }
            if (remain2 < plants[right]){
                remain2 = capacity2;
                refills++;
            }
            remain1 -= plants[left++];
            remain2 -= plants[right--];
        }
        if (left == right && plants[left] > remain1 + remain2)
            return ++refills;
        else
            return refills;
    }
}
