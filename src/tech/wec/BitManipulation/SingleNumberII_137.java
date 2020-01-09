package tech.wec.BitManipulation;

public class SingleNumberII_137 {
    // this is very obviously by using hashmap/hashset
    // change seen_once only if seen_twice is unchanged
    // change seen_twice only if seen_once is unchanged
    class Solution {
        public int singleNumber(int[] nums) {
            int seenOnce = 0, seenTwice = 0;
            for (int num: nums){
                seenOnce = ~seenTwice & (seenOnce ^ num);
                seenTwice = ~seenOnce & (seenTwice ^ num);
            }
            return seenOnce;
        }
    }
}
