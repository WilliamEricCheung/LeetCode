package tech.wec.Google;

import java.util.ArrayList;
import java.util.List;

public class StudentRows {
    static int solution(Integer[] A){
        List<Integer> head = new ArrayList<>();
        if (A.length <= 1)
            return A.length;
        head.add(A[0]);
        for (int i = 1; i < A.length; i++){
            Integer height = A[i];
            for (int j = 0; j < head.size(); j++){
                Integer h = head.get(j);
                if (height > h){
                    head.add(height);
                }else{
                    head.set(j, height);
                    break;
                }
            }
        }
        return head.size();
    }
}
