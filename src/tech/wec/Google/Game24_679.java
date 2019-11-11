package tech.wec.Google;

import java.util.ArrayList;

public class Game24_679 {
    public boolean judgePoint24(int[] nums){
        ArrayList<Double> A = new ArrayList();
        for (int num : nums) A.add((double)num);
        return solve(A);
    }

    private boolean solve(ArrayList<Double> nums){
        if (nums.size() == 0) return false;
        if (nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6;
        for (int i =0; i < nums.size(); i++){
            for (int j = 0; j < nums.size(); j++){
                if (i != j) {
                    ArrayList<Double> nums2 = new ArrayList<>();
                    for (int k = 0; k < nums.size(); k++)
                        if (k != i && k != j) {
                            nums2.add(nums.get(k));
                        }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue;
                        if (k == 0) nums2.add(nums.get(i) + nums.get(j));
                        if (k == 1) nums2.add(nums.get(i) * nums.get(j));
                        if (k == 2) nums2.add(nums.get(i) - nums.get(j));
                        if (k == 3) {
                            if (nums.get(j) != 0)
                                nums2.add(nums.get(i) / nums.get(j));
                            else
                                continue;
                        }
                        if (solve(nums2)) return true;
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
