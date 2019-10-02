package tech.wec.Facebook;

import tech.wec.HashTable.LongestWordInDictionary_720;

public class AddAndSearchWord_211 {
    class WordDictionary {

        Trie node;

        /** Initialize your data structure here. */
        public WordDictionary() {
            this.node = new Trie();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            node.add(word);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return node.find(word);
        }
    }

    class Trie{
        Trie child[];
        boolean ends;
        public Trie(){
            child = new Trie[26];
        }
        public void add(String w){
            Trie tmp = this;
            for (int i = 0; i < w.length(); i++){
                if (tmp.child[w.charAt(i)-'a'] == null)
                    tmp.child[w.charAt(i)-'a'] = new Trie();
                tmp = tmp.child[w.charAt(i)-'a'];
            }
            tmp.ends = true;
        }

        public boolean find(String w){
            Trie tmp = this;
            for (int i = 0; i < w.length(); i++){
                if (w.charAt(i) == '.'){
                    boolean ans = false;
                    for (int j = 0; j < 26; j++){
                        if (tmp.child[j] != null)
                            ans = ans | tmp.child[j].find(w.substring(i+1));
                    }
                    return ans;
                }
                if (tmp.child[w.charAt(i)-'a'] == null)
                    return false;
                else
                    tmp = tmp.child[w.charAt(i)-'a'];
            }
            return tmp.ends;
        }
    }
}
