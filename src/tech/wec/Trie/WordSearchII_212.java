package tech.wec.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchII_212 {



    // backtrace with trie
    class Solution {

        class TrieNode{
            HashMap<Character, TrieNode> children = new HashMap<>();
            String word = null;

            public TrieNode() {
            }
        }

        char[][] board = null;
        ArrayList<String> result = new ArrayList<>();

        public List<String> findWords(char[][] board, String[] words) {
            // Step 1: Construct the Trie
            TrieNode root = new TrieNode();
            for (String word : words) {
                TrieNode node = root;
                for (Character letter : word.toCharArray()) {
                    if (node.children.containsKey(letter)) {
                        node = node.children.get(letter);
                    } else {
                        TrieNode newNode = new TrieNode();
                        node.children.put(letter, newNode);
                        node = newNode;
                    }
                }
                node.word = word;
            }
            this.board = board;
            // Step 2: backtracking starting for each cell in the board
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (root.children.containsKey(board[row][col])) {
                        backtracking(row, col, root);
                    }
                }
            }
            return this.result;
        }

        private void backtracking(int row, int col, TrieNode parent){
            Character letter = this.board[row][col];
            TrieNode node = parent.children.get(letter);
            // check if there is any match
            if (node.word != null){
                this.result.add(node.word);
                node.word = null;
            }

            // mark the current letter before the exploration
            this.board[row][col] = '#';
            int[] rowOffset = {-1, 0, 1, 0};
            int[] colOffset = {0, 1, 0, -1};
            for (int i = 0; i < 4; i++){
                int newRow = row + rowOffset[i];
                int newCol = col + colOffset[i];
                if (newRow < 0 || newRow >= this.board.length
                        || newCol < 0 || newCol >= this.board[0].length)
                    continue;
                if(node.children.containsKey(this.board[newRow][newCol]))
                    backtracking(newRow, newCol, node);
            }
            this.board[row][col] = letter;
            if (node.children.isEmpty())
                parent.children.remove(letter);
        }
    }
}