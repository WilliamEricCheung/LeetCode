package tech.wec.iLoveZQW;

public class GasStation_134 {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int totalTank = 0, currentTank = 0;
            int startGas = 0;
            for (int i = 0; i < gas.length; i++){
                totalTank += gas[i] - cost[i];
                currentTank += gas[i] - cost[i];
                if (currentTank < 0){
                    startGas = i + 1; // 从下一站开始，之前都不行
                    currentTank = 0;
                }
            }
            return totalTank >= 0? startGas: -1;
        }
    }
}
