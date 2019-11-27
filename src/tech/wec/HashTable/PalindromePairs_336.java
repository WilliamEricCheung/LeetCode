package tech.wec.HashTable;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs_336 {

    class Solution {

        class Trie{
            int id;
            Trie[] children;
            List<Integer> pos;
            boolean hasWord;

            public Trie() {
                this.id = -1;
                this.children = new Trie[26];
                this.pos = new ArrayList<>();
                this.hasWord = false;
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        Trie root = new Trie();
        public List<List<Integer>> palindromePairs(String[] words) {
            if (words.length == 0) return result;
            for (int i = 0; i < words.length; i++)
                insert(words[i], i);
            for (int i = 0; i < words.length; i++)
                search(words[i], i);
            return result;
        }

        private void insert(String word, int index){
            Trie node = root;
            for (int i = word.length() - 1; i >= 0; i--){
                if (isPalindrome(word, 0, i)) node.pos.add(index);
                int k = word.charAt(i) - 'a';
                if (node.children[k] == null) node.children[k] = new Trie();
                node = node.children[k];
            }
            node.hasWord = true;
            node.pos.add(index);
            node.id = index;
        }

        private void search(String word, int index){
            Trie node = root;
            for (int i = 0; i < word.length(); i++){
                if (node.id >= 0 && node.id != index && isPalindrome(word, i, word.length() - 1)){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(index);
                    tmp.add(node.id);
                    result.add(tmp);
                }
                int k = word.charAt(i) - 'a';
                if (node.children[k] == null) return;
                node = node.children[k];
            }
            for (int item: node.pos){
                if (item == index) continue;
                List<Integer> tmp = new ArrayList<>();
                tmp.add(index);
                tmp.add(item);
                result.add(tmp);
            }
        }

        private boolean isPalindrome(String word, int start, int end){
            while(start < end){
                if (word.charAt(start) != word.charAt(end)) return false;
                start++; end--;
            }
            return true;
        }
    }
}
