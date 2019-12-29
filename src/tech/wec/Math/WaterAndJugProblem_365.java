package tech.wec.Math;

public class WaterAndJugProblem_365 {
    class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            if (x == 0 && y == 0 && z == 0) return true;
            return (x + y >= z) && (z % gcd(x, y) == 0);
        }

        // 辗转相除法
        private int gcd(int x, int y){
            return x == 0? y: gcd(y % x, x);
        }
    }
}
