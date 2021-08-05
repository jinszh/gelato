package gelato.leet1;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;

//173
public class BSTIterator {
    ArrayList<Integer> bst;
    Iterator<Integer> iterator;
    public BSTIterator(TreeNode root) {
        bst = new ArrayList<>();
        buildBST(root, bst);
        iterator = bst.iterator();
    }

    /** @return the next smallest number */
    public int next() {
        return iterator.next();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void buildBST(TreeNode root, ArrayList list){
        if(root.left != null){
            buildBST(root.left, list);
        }
        list.add(root.val);
        if(root.right != null){
            buildBST(root.right, list);
        }
    }
}
