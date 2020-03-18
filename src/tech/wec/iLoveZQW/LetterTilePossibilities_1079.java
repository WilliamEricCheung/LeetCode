package tech.wec.iLoveZQW;

public class LetterTilePossibilities_1079 {
    class Solution {
        public int numTilePossibilities(String tiles) {
            int[] a = new int[26];
            for (Character ch: tiles.toCharArray())
                a[ch - 'A']++;
            return helper(a);
        }

        private int helper(int[] a){
            int sum = 0;
            for (int i = 0; i < a.length; i++){
                if (a[i] == 0) continue;
                sum++;
                a[i]--;
                sum+=helper(a);
                a[i]++;
            }
            return sum;
        }
    }
}
