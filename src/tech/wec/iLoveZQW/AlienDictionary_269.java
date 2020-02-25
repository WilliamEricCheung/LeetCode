package tech.wec.iLoveZQW;

import java.util.*;

public class AlienDictionary_269 {
    class Solution {

        int[] inDegrees = new int[26];

        public String alienOrder(String[] words) {
            return topoSort(buildGraph(words), words);
        }

        private Map<Character, List<Character>> buildGraph(String[] words){
            Map<Character, List<Character>> graph = new HashMap<>();
            for (int i = 0; i < words.length - 1; i++){
                String cur = words[i];
                String next = words[i + 1];
                int minLen = Math.min(cur.length(), next.length());
                for (int j = 0; j < minLen; j++){
                    if (cur.charAt(j) != next.charAt(j)){
                        List<Character> list = graph.getOrDefault(cur.charAt(j), new ArrayList<>());
                        list.add(next.charAt(j));
                        graph.put(cur.charAt(j), list);
                        inDegrees[next.charAt(j) - 'a']++;
                        break;
                    }
                }
            }
            return graph;
        }

        private String topoSort(Map<Character, List<Character>> graph, String[] words){
            Set<Character> seen = getAllChars(words);
            StringBuilder ans = new StringBuilder();
            Queue<Character> queue = new LinkedList<>();
            for (char ch: seen) if (inDegrees[ch - 'a'] == 0) queue.offer(ch);
            while(!queue.isEmpty()){
                char cur = queue.remove();
                ans.append(cur);
                List<Character> nexts = graph.get(cur);
                if (nexts != null && !nexts.isEmpty()){
                    for (char next: nexts){
                        inDegrees[next - 'a']--;
                        if (inDegrees[next - 'a'] == 0)
                            queue.offer(next);
                    }
                }
            }
            return ans.toString().length() != seen.size()? "": ans.toString();
        }

        public Set<Character> getAllChars(String[] words){
            Set<Character> seen = new HashSet<>();
            for (String word: words){
                for(char ch: word.toCharArray())
                    seen.add(ch);
            }
            return seen;
        }
    }
}
