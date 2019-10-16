package tech.wec.Google;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// This is the robot's control interface.
// You should not implement it, or speculate about its implementation
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
}


public class RobotRoomCleaner_489 {

    class Pair<F, S>{
        public F first;
        public S second;

        public Pair(F first, S second){
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o){
            Pair<F, S> p = (Pair<F, S>) o;
            return Objects.equals(p.first, first) && Objects.equals(p.second, second);
        }

        @Override
        public int hashCode(){
            return first.hashCode() ^ second.hashCode();
        }
    }

    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    Robot robot;

    public void goBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    /**
     *
     * @param row row
     * @param col column
     * @param d direction
     */
    public void backtrack(int row, int col, int d){
        visited.add(new Pair(row, col));
        robot.clean();
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; i++){
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];
            if (!visited.contains(new Pair(newRow, newCol)) && robot.move()){
                backtrack(newRow, newCol, newD);
                goBack();
            }
            // turn the robot following chosen direction: clockwise
            robot.turnRight();
        }
    }

    // Spiral Backtracking
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0,0,0);
    }
}
