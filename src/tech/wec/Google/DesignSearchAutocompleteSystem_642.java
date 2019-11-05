package tech.wec.Google;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 使用字典树
public class DesignSearchAutocompleteSystem_642 {

    public static void main(String[] args) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        list.add(new Pair<>(1, 2));
        list.add(new Pair<>(2, 3));
        list.add(new Pair<>(3, 4));
        list.add(new Pair<>(5, 6));
        Collections.sort(list, (a, b)-> b.getValue() - a.getValue());
        Collections.sort(list, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p2.getValue() - p1.getValue();
            }
        });
    }

    class AutocompleteSystem {

        class Node{
            private String sentence;
            private int times;

            public Node(String sentence, int times) {
                this.sentence = sentence;
                this.times = times;
            }

            public String getSentence() {
                return sentence;
            }

            public void setSentence(String sentence) {
                this.sentence = sentence;
            }

            public int getTimes() {
                return times;
            }

            public void setTimes(int times) {
                this.times = times;
            }
        }

        class Trie{
            int times;
            Trie[] branches = new Trie[27];
        }

        private int toInt(char c){
            return c == ' '? 26 : c - 'a';
        }

        private void insert(Trie t, String s, int times){
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (t.branches[toInt(c)] == null)
                    t.branches[toInt(c)] = new Trie();
                t = t.branches[toInt(c)];
            }
            t.times += times;
        }

        private List<Node> lookup(Trie t, String s){
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (t.branches[toInt(c)] == null)
                    return new ArrayList<>();
                t = t.branches[toInt(c)];
            }
            traverse(s, t, list);
            return list;
        }

        private void traverse(String s, Trie t, List<Node> list){
            if (t.times > 0)
                list.add(new Node(s, t.times));
            for (char i = 'a'; i <= 'z'; i++){
                if (t.branches[i - 'a'] != null)
                    traverse(s + i, t.branches[i - 'a'], list);
            }
            if (t.branches[26] != null)
                traverse(s + " ", t.branches[26], list);
        }

        private Trie root;
        private String curSent = "";

        public AutocompleteSystem(String[] sentences, int[] times) {
            root = new Trie();
            for (int i = 0; i < sentences.length; i++)
                insert(root, sentences[i], times[i]);
        }

        public List<String> input(char c) {
            List<String> res = new ArrayList<>();
            if (c == '#'){
                insert(root, curSent, 1);
                curSent = "";
            }else{
                curSent += c;
                List<Node> list = lookup(root, curSent);
                Collections.sort(list, (a, b)->
                        a.times == b.times? a.sentence.compareTo(b.sentence) : b.times - a.times);
                for (int i = 0; i < Math.min(3, list.size()); i++)
                    res.add(list.get(i).sentence);
            }
            return res;
        }
    }
}
