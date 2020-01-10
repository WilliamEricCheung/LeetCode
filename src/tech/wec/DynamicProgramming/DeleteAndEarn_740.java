package tech.wec.DynamicProgramming;

public class DeleteAndEarn_740 {
    class Solution {
        public int deleteAndEarn(int[] nums) {
             int using = 0; // the value of our previous answer
             int avoid = 0; // the value of our previous answer that doesn't use the previously largest value prev
             int prev = 0;
             int[] count = new int[10001];
             for (int num: nums) count[num]++;
             for (int k = 0; k <= 10000; k++) if (count[k] > 0){
                 int max = Math.max(avoid, using);
                 if (k - 1 != prev){
                     using = k * count[k] + max;
                     avoid = max;
                 }else{
                     using = k * count[k] + avoid;
                     avoid = max;
                 }
                 prev = k;
             }
             return Math.max(avoid, using);
        }
    }
}
