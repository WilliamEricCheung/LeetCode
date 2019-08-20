package tech.wec.Math;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int i =0;i<len;i++){
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) continue;
            nums[x - 1] *= -1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0;i<len;i++)
            if (nums[i]>0)
                ans.add(i+1);
        return ans;
    }
}
