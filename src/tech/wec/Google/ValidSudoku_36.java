package tech.wec.Google;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        // init
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] cols = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++){
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        // check
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                char num = board[i][j];
                if (num != '.'){
                    int n = num - '0';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    // put value into map
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
                    boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);
                    // check
                    if (rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[boxIndex].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }
}
