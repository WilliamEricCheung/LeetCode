package tech.wec.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SubstringWithConcatenationOfAllWords_30 {

    // method 1: get all permutation and find the all index
    // however, it will go time limit error
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0)
            return new ArrayList<>();
        List<List<String>> permutations = new ArrayList<>();
        int[] visited = new int[words.length];
        Arrays.sort(words);

        getPermutations(words, permutations, new ArrayList<>(), visited);
        List<String> candidates = new ArrayList<>();
        for (List<String> permutation : permutations){
            StringBuilder sb = new StringBuilder();
            for (String word : permutation){
                sb.append(word);
            }
            candidates.add(sb.toString());
        }
        System.out.println(Arrays.toString(candidates.toArray()));
        List<Integer> result = new ArrayList<>();
        for (String cand : candidates){
            int idx = -1;
            while(idx <= s.lastIndexOf(cand)){
                idx = s.indexOf(cand, idx);
                if (idx != -1)
                    result.add(idx);
                idx++;
            }
        }
        return result;
    }

    private void getPermutations(String[] words,List<List<String>> permutations ,List<String> permutation, int[] visited){
        if (permutation.size() == words.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < words.length; i++){
            if (visited[i] == 1 || (i > 0 && visited[i-1] == 0 && words[i-1].equals(words[i])))
                continue;
            visited[i]=1;
            permutation.add(words[i]);
            getPermutations(words, permutations, permutation, visited);
            visited[i]=0;
            permutation.remove(permutation.size() - 1);
        }
    }

    // method 2: sliding window
    public List<Integer> findSubString(String s, String[] words){
        if (s.length() == 0 || words.length == 0)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int length = words[0].length();
        for (int i = 0; i <= s.length() - (words.length * length); i++){
            int j = i;
            ArrayList<String> tmp = new ArrayList<>(Arrays.asList(words));
            while(j + length <= s.length() && tmp.contains(s.substring(j, j+length))){
                tmp.remove(s.substring(j, j+length));
                j+=length;
            }
            if (tmp.size() == 0)
                result.add(i);
        }
        return result;
    }
}
