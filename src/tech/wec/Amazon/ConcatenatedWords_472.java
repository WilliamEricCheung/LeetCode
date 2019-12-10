package tech.wec.Amazon;

import java.util.*;

public class ConcatenatedWords_472 {
    // implement with recursive method
    class Solution_1{
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            Set<String> wordSet = new HashSet<>(Arrays.asList(words));
            List<String> result = new ArrayList<>();
            for (String word: words){
                if (getConcats(word, wordSet, 0) > 1)
                    result.add(word);
            }
            return result;
        }

        public int getConcats(String word, Set<String> wordSet, int concats){
            int start = 0;
            for(int i = 1; i <= word.length(); i++){
                String cur = word.substring(start, i);
                if(wordSet.contains(cur)){
                    if(i == word.length()) return concats + 1;
                    else{
                        int next = getConcats(word.substring(i), wordSet, concats + 1);
                        if(next > 1) return next;
                    }
                }
            }
            return -1;
        }
    }

    class Solution_2{
        class TrieNode{
            public TrieNode children[] = new TrieNode[26];
            public boolean isWord;
            public TrieNode(){
                this.isWord = false;
            }
        }

        class Trie{
            private TrieNode node;
            public Trie(){
                node = new TrieNode();
            }

            public void insert(final String word){
                TrieNode root = node;
                for(int i = 0; i < word.length(); i++){
                    int index = word.charAt(i) - 'a';
                    if(root.children[index] == null) root.children[index] = new TrieNode();
                    root = root.children[index];
                }
                root.isWord = true;
            }

            public boolean check(final String word){
                TrieNode root = node;
                for (int i = 0; i < word.length(); i++){
                    int index = word.charAt(i) - 'a';
                    if(root.children[index] == null) return false;
                    root = root.children[index];
                }
                return root.isWord;
            }
        }

        private Trie trie;
        public List<String> findAllConcatenatedWordsInADict(String[] words){
            trie = new Trie();
            List<String> result = new ArrayList<>();
            for(String word: words) trie.insert(word);
            for(String word: words) if (valid(word)) result.add(word);
            return result;
        }

        private boolean valid(final String word){
            if(word.length() <= 1 && !trie.check(word)) return false;
            String leftStr = "";
            String rightStr = "";
            int len = word.length() - 1;
            for (int i = 0; i < len; i++){
                leftStr += word.charAt(i);
                rightStr = word.substring(i+1);
                if (trie.check(leftStr) && (trie.check(rightStr) || valid(rightStr))) return true;
            }
            return false;
        }
    }
}
