package tech.wec.Array;

public class RotateArray_189 {

    // this problem is much like problem 61 -- Rotate List
    // but you can do it in sequence not reverse
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int cnt = 0;
        for (int start = 0; cnt<len;start++){
            int cur = start;
            int prev = nums[start];
            do{
                int next = (cur + k) % len;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                cur = next;
                cnt++;
            }while(start != cur);
        }
    }
}