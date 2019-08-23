package tech.wec.Brainteaser;

public class MaxConsecutiveOnes_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cnt = 0;
        for (int n: nums){
            if (n == 0) {
                if (cnt > max)
                    max = cnt;
                cnt = 0;
            }
            if (n == 1)
                cnt++;
        }
        return max < cnt && cnt > 0? cnt : max;
    }
}
