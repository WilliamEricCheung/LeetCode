package tech.wec.Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph_133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    private void dfs(Node node, HashMap<Node, Node> hash){
        if (node == null)
            return;
        if (!hash.containsKey(node)){
            Node newNode = new Node();
            newNode.val = node.val;
            hash.put(node, newNode);
            for (Node n: node.neighbors)
                dfs(n, hash);
        }
    }

    private void popNeighbors(HashMap<Node, Node> hash){
        for (Node n : hash.keySet()){
            Node tmp = hash.get(n);
            List<Node> tmp1 = new ArrayList<>();
            for (Node a : n.neighbors){
                tmp1.add(hash.get(a));
            }
            tmp.neighbors = tmp1;
        }
    }

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> hash = new HashMap<>();
        dfs(node, hash);
        popNeighbors(hash);
        return hash.get(node);
    }
}
