package tech.wec.Array;

public class IncreasingTripletSubsequence_334 {
    public boolean increasingTriplet(int[] nums) {
        Integer prev1 = null;
        Integer prev2 = null;
        for (int num: nums){
            if (prev2 != null && num > prev2) return true;
            if (prev1 == null || prev1 > num) prev1 = num; // 当前最小
            else if (prev1 != num && (prev2 == null || prev2 > num)) prev2 = num;
        }
        return false;
    }
}
