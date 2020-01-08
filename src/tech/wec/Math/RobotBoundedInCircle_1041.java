package tech.wec.Math;

public class RobotBoundedInCircle_1041 {
    class Solution {
        public boolean isRobotBounded(String instructions) {
            int x = 0, y = 0, index = 0;
            int[][] directions = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
            for (Character ch: instructions.toCharArray()){
                switch (ch){
                    case 'L':
                        index = (index + 1) % 4;
                        break;
                    case 'R':
                        index = (index + 3) % 4;
                        break;
                    default:
                        x += directions[index][0];
                        y += directions[index][1];
                }
            }
            return x == 0 && y == 0 || index > 0;
        }
    }
}
