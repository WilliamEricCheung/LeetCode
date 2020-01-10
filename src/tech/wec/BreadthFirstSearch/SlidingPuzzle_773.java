package tech.wec.BreadthFirstSearch;

import java.util.*;

public class SlidingPuzzle_773 {
    class Solution {
        public int slidingPuzzle(int[][] board) {
            Map<String, Integer> map = new HashMap<>();
            String finalState = makeString(new int[][]{{1,2,3},{4,5,0}});
            map.put(finalState, 0);
            Queue<String> queue = new LinkedList<>();
            queue.add(finalState);
            while(!queue.isEmpty()){
                String curState = queue.remove();
                List<String> adjs = adjStates(curState);
                for (String adj: adjs){
                    if (!map.containsKey(adj)){
                        queue.add(adj);
                        map.put(adj, map.get(curState) + 1);
                    }else map.put(adj, Math.min(map.get(adj), map.get(curState) + 1));
                }
            }
            String originState = makeString(board);
            if (map.containsKey(originState)) return map.get(originState);
            else return -1;
        }

        private List<String> adjStates(String board){
            List<String> list = new ArrayList<>();
            if (board.charAt(0) == '0'){
                // 0 1 2
                // 3 4 5
                list.add(swap(board, 0, 3));
                list.add(swap(board, 0, 1));
            }
            if (board.charAt(1) == '0'){
                // 1 0 2
                // 3 4 5
                list.add(swap(board, 1, 0));
                list.add(swap(board, 1, 2));
                list.add(swap(board, 1, 4));
            }
            if (board.charAt(2) == '0'){
                // 1 2 0
                // 3 4 5
                list.add(swap(board, 2, 1));
                list.add(swap(board, 2, 5));
            }
            if (board.charAt(3) == '0'){
                // 1 2 3
                // 0 4 5
                list.add(swap(board, 3, 0));
                list.add(swap(board, 3, 4));
            }
            if (board.charAt(4) == '0'){
                // 1 2 3
                // 4 0 5
                list.add(swap(board, 4, 3));
                list.add(swap(board, 4, 1));
                list.add(swap(board, 4, 5));
            }
            if (board.charAt(5) == '0'){
                // 1 2 3
                // 4 5 0
                list.add(swap(board, 5, 4));
                list.add(swap(board, 5, 2));
            }
            return list;
        }

        private String swap(String string, int i, int j){
            StringBuilder sb = new StringBuilder(string);
            char ch = string.charAt(j);
            sb.setCharAt(j, string.charAt(i));
            sb.setCharAt(i, ch);
            return sb.toString();
        }

        private String makeString(int[][] board){
            return "" + board[0][0] + board[0][1] + board[0][2]
                    + board[1][0] + board[1][1] + board[1][2];
        }
    }
}
