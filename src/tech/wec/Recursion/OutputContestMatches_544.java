package tech.wec.Recursion;

public class OutputContestMatches_544 {
    class Solution {
        private int[] team;
        private int t;
        private StringBuilder sb;
        public String findContestMatch(int n) {
            team = new int[n];
            t = 0;
            sb = new StringBuilder();
            helper(n, Integer.numberOfTrailingZeros(n));
            return sb.toString();
        }

        private void helper(int n, int round){
            if (round == 0){
                int w = Integer.lowestOneBit(t);
                team[t] = w > 0? n / w + 1 - team[t - w] : 1;
                sb.append("" + team[t++]);
            }else{
                sb.append("(");
                helper(n, round - 1);
                sb.append(",");
                helper(n, round - 1);
                sb.append(")");
            }
        }
    }
}
