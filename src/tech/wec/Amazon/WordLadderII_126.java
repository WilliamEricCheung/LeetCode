package tech.wec.Amazon;

import javafx.util.Pair;

import java.util.*;

public class WordLadderII_126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return result;
        Map<String, List<String>> parents = new HashMap<>();
        for (String word: words) parents.put(word, new ArrayList<>());
        Map<String, Integer> distance = new HashMap<>(); // distance from one word to beginWord
        distance.put(beginWord, 0);
        boolean found = bfs(beginWord, endWord, words, distance, parents);
        if (found) dfs(endWord, beginWord, endWord, parents, result, new ArrayList<>());
        return result;
    }

    private boolean bfs(String beginWord, String endWord, Set<String> words, Map<String, Integer> distance,
                        Map<String, List<String>> parents){
        boolean found = false;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        while(!queue.isEmpty() && !found){
            level++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++){
                String word = queue.poll();
                List<String> nexts = getNexts(word, words);
                for (String next: nexts){
                    if (next.equals(endWord)) found = true;
                    if (!distance.containsKey(next)){
                        // if "next" has not been visited before
                        queue.offer(next);
                        distance.put(next, level);
                        parents.get(next).add(word);
                    }else if (distance.get(next) == distance.get(word) + 1){
                        // if "next" has been visited before, but in current level
                        // No need to add to queue again, because it has been appeared in this level
                        parents.get(next).add(word);
                    }
                }
            }
        }
        return found;
    }

    private List<String> getNexts(String word, Set<String> words){
        List<String> nexts = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){
            for (char c = 'a'; c <= 'z'; c++){
                if (chars[i] == c) continue;
                char tmp = chars[i];
                chars[i] = c;
                String newWord = String.valueOf(chars);
                if (words.contains(newWord)) nexts.add(newWord);
                chars[i] = tmp;
            }
        }
        return nexts;
    }

    // dfs: search paths
    private void dfs(String word, String beginWord, String endWord, Map<String, List<String>> parents,
                     List<List<String>> result, List<String> path){
        if (word.equals(beginWord)){
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            result.add(copy);
            return;
        }
        if (word.equals(endWord)) path.add(endWord);
        for (String parent: parents.get(word)){
            path.add(parent);
            dfs(parent, beginWord, endWord, parents, result, path);
            path.remove(path.size() - 1);
        }
    }
}
