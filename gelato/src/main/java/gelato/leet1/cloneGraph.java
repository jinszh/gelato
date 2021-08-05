package gelato.leet1;

import java.util.*;

//133
public class cloneGraph {
    public Node cloneGraph(Node node) {
        HashSet<Node> visited = new HashSet<>();
        HashMap<Node, Node> cloned = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);
        Node root = new Node(node.val, new ArrayList<>());
        cloned.put(node, root);

        while (!queue.isEmpty()){
            Node head = queue.pollFirst();
            for(Node nb : head.neighbors){
                if(!visited.contains(nb)){
                    queue.add(nb);
                    Node n = new Node(nb.val, new ArrayList<>());
                    cloned.put(nb, n);
                    visited.add(nb);
                }
                cloned.get(head).neighbors.add(cloned.get(nb));
            }
        }
        return root;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
}
