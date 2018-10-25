package gelato.algos;

import java.util.*;

public class SortPartialOrderStrings {
    public boolean isSorted(String [] inputs){
        HashMap<String, Node> nodeMap = new HashMap<>();
        for(String s : inputs) {
            String[] nums;
            if (s.contains("<")) {
                nums = s.split("<");
            } else {
                nums = s.split(">");
            }
            nodeMap.putIfAbsent(nums[0], new Node(nums[0]));
            nodeMap.putIfAbsent(nums[1], new Node(nums[1]));
            Node left = nodeMap.get(nums[0]);
            Node right = nodeMap.get(nums[1]);
            if (s.contains("<") && !left.edgesTo.contains(right)) {
                left.edgesTo.add(right);
                right.inDegree++;
            } else if(!right.edgesTo.contains(left)) {
                right.edgesTo.add(left);
                left.inDegree++;
            }
        }
        PriorityQueue<Node> nodes = new PriorityQueue<Node>((o1, o2) -> (Integer.compare(((Node)o1).inDegree, ((Node)o2).inDegree)));
        nodes.addAll(nodeMap.values());
        while (!nodes.isEmpty()) {
            Node n = nodes.peek();
            if(n.inDegree != 0){
                break;
            }
            nodes.poll();
            System.out.print(n.value + " ");
            for(Node end : n.edgesTo){
                nodes.remove(end);
                end.inDegree--;
                nodes.add(end);
            }
        }
        if(!nodes.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public  class Node implements Cloneable{
        public String value;
        public ArrayList<Node> edgesTo = new ArrayList<>();
        public int inDegree = 0;

        public Node(String v){
            this.value = v;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof  Node) && ((Node)obj).value.equals(value);
        }
    }
}
