package gelato.leet5;

//510
public class inorderSuccessor {
    public Node inorderSuccessor(Node x) {
        Node res;
        if (x.right != null) {
            res = x.right;
            while (res.left != null) res = res.left;
            return res;
        } else {
            res = x;
            while (res.parent != null && res == res.parent.right){
                res = res.parent;
            }
            if(res.parent != null && res.parent.left == res){
                return res.parent;
            }else {
                return null;
            }
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}
