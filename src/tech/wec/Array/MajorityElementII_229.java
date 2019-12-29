package tech.wec.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII_229 {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        int threshold = nums.length / 3 + 1; // need to >= threshold
        // 找出两个出现数量最多的数，判断是否达到阈值
        List<Integer> result = new ArrayList<>();
        int ans1 = nums[0];
        int ans1Cnt = 1;
        int ans2 = 0;
        int ans2Cnt = 1;
        boolean flag = true;
        for (int num: nums){
            if (num == ans1) ans1Cnt++;
            else if (flag){
                // 可能的第二多数
                ans2 = num;
                flag = false;
            }else if (ans2 == num) ans2Cnt++;
            else if (ans1Cnt == 0){
                ans1 = num;
                ans1Cnt++;
            }else if (ans2Cnt == 0){
                ans2 = num;
                ans2Cnt++;
            }else{
                ans1Cnt--;
                ans2Cnt--;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums){
            if (num == ans1) cnt1++;
            if (num == ans2) cnt2++;
        }
        if (cnt1 >= threshold) result.add(ans1);
        if (!flag && cnt2 >= threshold) result.add(ans2);
        return result;
    }
}
