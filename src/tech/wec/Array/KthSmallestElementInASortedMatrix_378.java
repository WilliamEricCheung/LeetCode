package tech.wec.Array;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInASortedMatrix_378 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(matrix, 8));
    }

    static class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int[] integers = new int[n * n];
            for (int i = 0; i < n; i++){
                merge(integers,matrix[i], i * n - 1);
            }
            return integers[k-1];
        }

        private void merge(int[] integers,int[] row, int length){
            int[] tmp = new int[length + 1];
            for (int i = 0; i <= length; i++) tmp[i] = integers[i];
            int idxTmp = 0, idxRow = 0, idxList = 0;
            while(idxTmp < tmp.length || idxRow < row.length){
                if (idxTmp >= tmp.length || tmp[idxTmp] > row[idxRow])
                    integers[idxList] = row[idxRow++];
                else integers[idxList] = tmp[idxTmp++];
                idxList++;
            }
        }
    }
}
