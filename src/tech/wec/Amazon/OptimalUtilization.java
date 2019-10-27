package tech.wec.Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OptimalUtilization {

    public List<int[]> getOptimalPair(List<int[]> a, List<int[]> b, int target){
        Collections.sort(a, (a1 ,a2)->a1[1] - a2[1]);
        Collections.sort(b, (b1, b2)->b1[1] - b2[1]);
        List<int[]> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int pa = 0;
        int pb = b.size() - 1;
        // 双指针查询，
        while(pa < a.size() && pb >= 0){
            int sum = a.get(pa)[1] + b.get(pb)[1];
            if (sum > target)
                pb--;
            else{
                if (max <= sum){
                    // 取代过去存的
                    if (max < sum){
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(pa)[0], b.get(pb)[0]});
                    // 如果b连续的相同值
                    int idx = pb - 1;
                    while(idx >=0 && b.get(idx)[1] == b.get(idx+1)[1]){
                        result.add(new int[]{a.get(pa)[0], a.get(idx--)[0]});
                    }
                }
                pa++;
            }
        }
        return result;
    }
}
