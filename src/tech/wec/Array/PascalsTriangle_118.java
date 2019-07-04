package tech.wec.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {

    // Dynamic Programming
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i =0;i<numRows;i++){
            row.add(0, 1);
            for (int j=1;j<row.size()-1;j++){
                row.set(j,row.get(j)+row.get(j+1));
            }
            result.add(new ArrayList<>(row));
        }
        return result;
    }

    // Math method cannot work cause it would exceed the limit of Integer
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i =0;i<numRows;i++){
//            List<Integer> item = new ArrayList<>();
//            for (int j=0;j<=i;j++){
//
//                item.add(combination(i, j));
//            }
//            //System.out.println(item);
//            result.add(item);
//        }
//        return result;
//    }
//    public int combination(int n, int m){
//        if (m==0)
//            return 1;
//        else{
//            return factorial(n) / (factorial(m) * factorial(n-m));
//        }
//    }
//    public int factorial(int n){
//        int res = 1;
//        for (int i =1;i<=n;i++){
//            res *= i;
//        }
//        return res;
//    }
}
