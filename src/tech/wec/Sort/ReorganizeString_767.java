package tech.wec.Sort;

import java.util.PriorityQueue;

public class ReorganizeString_767 {
    class Solution {
        public String reorganizeString(String S) {
            int n = S.length();
            int[] count = new int[26];
            for (char ch : S.toCharArray()) count[ch - 'a']++;
            PriorityQueue<MultiChar> pq = new PriorityQueue<>((a, b) -> a.count == b.count ? a.letter - b.letter : b.count - a.count);
            for (int i = 0; i < 26; i++) if (count[i] > 0){
                if (count[i] > (n + 1) / 2) return "";
                pq.add(new MultiChar(count[i], (char)('a' + i)));
            }
            StringBuilder sb = new StringBuilder();
            while(pq.size() >= 2){
                MultiChar mc1 = pq.poll();
                MultiChar mc2 = pq.poll();
                sb.append(mc1.letter);
                sb.append(mc2.letter);
                if (--mc1.count > 0) pq.add(mc1);
                if (--mc2.count > 0) pq.add(mc2);
            }
            if(pq.size() > 0) sb.append(pq.poll().letter);
            return sb.toString();
        }

        class MultiChar{
            int count;
            char letter;

            public MultiChar(int count, char letter) {
                this.count = count;
                this.letter = letter;
            }
        }
    }
}
