package tech.wec.Amazon;

import javafx.util.Pair;

import java.util.*;

public class WordLadder_127 {
    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        List<List<String>> result = new ArrayList<>();
        Map<String, ArrayList<String>> dict = new HashMap<>();
        wordList.forEach(word ->{
            for (int i = 0; i < len; i++){
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                ArrayList<String> transformed = dict.getOrDefault(newWord, new ArrayList<>());
                transformed.add(word);
                dict.put(newWord,transformed);
            }
        });

        // queue for bfs
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while(!queue.isEmpty()){
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; i++){
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);
                for (String adj: dict.getOrDefault(newWord, new ArrayList<>())){
                    if (adj.equals(endWord)) return level + 1;
                    if (!visited.containsKey(adj)){
                        visited.put(adj, true);
                        queue.add(new Pair<>(adj, level + 1));
                    }
                }
            }
        }
        return 0;
    }

}
