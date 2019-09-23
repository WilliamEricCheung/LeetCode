package tech.wec.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i =0;i<=rowIndex;i++){
            row.add(0, 1);
            for (int j=1;j<row.size()-1;j++){
                row.set(j,row.get(j)+row.get(j+1));
            }
        }
        return row;
    }

    // math
    public List<Integer> getRow_1(int rowIndex){
        Integer[] row = new Integer[rowIndex + 1];
        Arrays.fill(row, 1);
        for (int i = 1; i <= rowIndex / 2; i++){
            double tmp = ((double)(rowIndex - i + 1)/i * row[i - 1]);
            row[i] = row[rowIndex - i] = (int) tmp;
        }
        return new ArrayList<>(Arrays.asList(row));
//        return List.of(row); Java 9
    }
}
