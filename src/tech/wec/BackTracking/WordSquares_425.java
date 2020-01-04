package tech.wec.BackTracking;

import tech.wec.Tree.TreeNode;

import java.util.*;

public class WordSquares_425 {
    // backtrack with trie
    class Solution {

        class Trie{
            Map<Character, Trie> children;
            List<Integer> wordList;
            public Trie(){
                children = new HashMap<>();
                wordList = new ArrayList<>();
            }
        }

        private int n;
        private String[] words;
        private Trie trie;
        private List<List<String>> result;

        public List<List<String>> wordSquares(String[] words) {
            this.words = words;
            this.n = words[0].length();
            this.result = new ArrayList<>();
            this.buildTrie(words);
            for (String word: words){
                LinkedList<String> wordSquares = new LinkedList<>();
                wordSquares.addLast(word);
                this.backtrack(1, wordSquares);
            }
            return result;
        }

        private void backtrack(int step, LinkedList<String> wordSquares){
            if (step == n){
                result.add((List<String>)wordSquares.clone());
                return;
            }
            StringBuilder prefix = new StringBuilder();
            for (String word: wordSquares){
                prefix.append(word.charAt(step));
            }
            for (Integer wordIndex: this.getWordWithPrefix(prefix.toString())){
                wordSquares.addLast(this.words[wordIndex]);
                this.backtrack(step + 1, wordSquares);
                wordSquares.removeLast();
            }
        }

        private void buildTrie(String[] words){
            this.trie = new Trie();
            for (int i = 0; i < words.length; i++){
                String word = words[i];
                Trie node = this.trie;
                for (Character letter: word.toCharArray()){
                    if (node.children.containsKey(letter)) node = node.children.get(letter);
                    else{
                        Trie newNode = new Trie();
                        node.children.put(letter, newNode);
                        node = newNode;
                    }
                    node.wordList.add(i);
                }
            }
        }

        private List<Integer> getWordWithPrefix(String prefix){
            Trie node = this.trie;
            for (Character letter: prefix.toCharArray()){
                if (node.children.containsKey(letter)) node = node.children.get(letter);
                else return new ArrayList<>();
            }
            return node.wordList;
        }
    }
}
