package tech.wec.Google;

public class CircularArrayLoop_457 {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            nums[i] %= n;
        for (int i = 0; i < n; i++){
            int idx = i, last_idx = 0;
            boolean is_forward = nums[i] > 0;
            while(nums[idx] % n != 0 && nums[idx] > 0 == is_forward){
                last_idx = idx;
                idx = (idx + nums[idx] + n) % n;
                nums[last_idx] = (i + 1) * n;
                if (nums[idx] == (i + 1) * n)
                    return true;
            }
        }
        return false;
    }
}
