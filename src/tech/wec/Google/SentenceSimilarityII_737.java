package tech.wec.Google;

import java.util.*;

public class SentenceSimilarityII_737 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Integer> words = new HashMap<>();
        int cnt = 0;
        DSU dsu = new DSU(2 * pairs.size());
        for (List pair : pairs){
            if (!words.containsKey(pair.get(0)))
                words.put(pair.get(0).toString(), cnt++);
            if (!words.containsKey(pair.get(1)))
                words.put(pair.get(1).toString(), cnt++);
            dsu.union(words.get(pair.get(0).toString()), words.get(pair.get(1).toString()));
        }

        for (int i = 0; i < words1.length; i++){
            String w1 = words1[i], w2 = words2[i];
            if (w1.equals(w2)) continue;
            if (!words.containsKey(w1) || !words.containsKey(w2) ||
            dsu.find(words.get(w1)) != dsu.find(words.get(w2)))
                return false;
        }
        return true;
    }

    class DSU{
        int[] parent;
        public DSU(int n){
            parent = new int[n];
            for (int i =  0;i < n; i++)
                parent[i] = i;
        }

        public int find(int x){
            if (parent[x]!=x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y){
            parent[find(x)] = find(y);
        }
    }
}
