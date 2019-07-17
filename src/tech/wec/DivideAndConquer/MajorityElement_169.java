package tech.wec.DivideAndConquer;


/**solving methods:
 * 1. brute force
 * 2. hash map
 * 3. sort
 * 4. Boyer-Moore Voting Algorithm
  */
public class MajorityElement_169 {
    // Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num: nums){
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
