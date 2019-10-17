package tech.wec.Google;

public class MinDaysToBloom {

    public static void main(String[] args) {
        int[] roses = new int[]{1,1,1,1,9,3,2,1};
        System.out.println(minDaysBloom(roses, 2, 2));
    }

    // binary search
    public static int minDaysBloom(int[] roses, int k, int n){
        int left = 0;
        int right = 0;
        for (int rose : roses)
            if (rose > right)
                right = rose;
        while(left < right){
            int mid = left + (right - left) / 2;
            int bouquets = 0;
            int cnt = 0;
            for (int i = 0; i < roses.length; i++){
                if (roses[i] <= mid){
                    cnt++;
                }else if (roses[i] > mid && cnt < k){
                    cnt = 0;
                    continue;
                }

                if (cnt >= k){
                    bouquets++;
                    cnt -= k;
                }
            }
            if (bouquets < n)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
