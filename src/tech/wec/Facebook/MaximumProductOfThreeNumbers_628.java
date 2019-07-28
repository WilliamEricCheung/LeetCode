package tech.wec.Facebook;

public class MaximumProductOfThreeNumbers_628 {

    public int maximumProduct(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;
        for (int num : nums){
            if (num <= min1){
                min2 = min1;
                min1 = num;
            }
            else if (num <= min2){
                min2 = num;
            }
            if (num >= first){
                third = second;
                second = first;
                first = num;
            }
            else if (num >= second && num < first){
                third = second;
                second = num;
            }
            else if (num >= third && num < second){
                third = num;
            }
        }
        return Math.max((int)(first * second * third), (int)(first * min1 * min2));
    }
}
