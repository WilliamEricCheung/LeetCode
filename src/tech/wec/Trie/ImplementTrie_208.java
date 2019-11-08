package tech.wec.Trie;

public class ImplementTrie_208 {
    class Trie {

        class TrieNode{
            private TrieNode[] next;
            private final int R = 26;
            private boolean isEnd = false;

            public TrieNode() {
                next = new TrieNode[R];
            }

            public boolean containsKey(char ch){
                return next[ch - 'a'] != null;
            }

            public TrieNode get(char ch){
                return  next[ch - 'a'];
            }

            public void put(char ch, TrieNode node){
                next[ch - 'a'] = node;
            }
            public void setEnd(){
                isEnd = true;
            }

            public boolean isEnd(){
                return isEnd;
            }
        }

        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0;i< word.length(); i++){
                char ch = word.charAt(i);
                if (!node.containsKey(ch)){
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        private TrieNode searchPrefix(String word){
            TrieNode node = root;
            for (int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if (node.containsKey(ch)){
                    node = node.get(ch);
                }else
                    return null;
            }
            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word){
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }
}
