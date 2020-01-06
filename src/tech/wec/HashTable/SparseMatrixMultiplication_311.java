package tech.wec.HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SparseMatrixMultiplication_311 {
    class Solution {

        public int[][] multiply(int[][] A, int[][] B) {
            // map用来指示B矩阵的i行j列值 key=row value= key: col, value: v
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            int[][] result = new int[A.length][B[0].length];
            for (int i = 0; i < B.length; i++){
                for (int j = 0; j < B[0].length; j++){
                    if (B[i][j] != 0){
                        if (!map.containsKey(i))
                            map.put(i, new HashMap<>());
                        map.get(i).put(j, B[i][j]);
                    }
                }
            }
            for (int i = 0; i < A.length; i++){
                for (int j = 0; j < A[0].length; j++){
                    if (A[i][j] != 0 && map.containsKey(j)){
                        Map<Integer, Integer> cols = map.get(j);
                        for (Map.Entry<Integer, Integer> entry: cols.entrySet()){
                            result[i][entry.getKey()] += A[i][j] * entry.getValue();
                        }
                    }
                }
            }
            return result;
        }
    }
}
