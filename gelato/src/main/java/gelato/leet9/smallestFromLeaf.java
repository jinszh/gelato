package gelato.leet9;

import gelato.model.TreeNode;

public class smallestFromLeaf {
    String minLexco = null;
    public String smallestFromLeaf(TreeNode root) {
        String suffix = new String(new char[]{(char)(root.val + 'a')});
        if(root.left != null){
            trav(root.left, 1, suffix);
        }
        if(root.right != null){
            trav(root.right, 1, suffix);
        }
        if(root.left == null && root.right == null){
            minLexco = suffix;
        }
        return minLexco;
    }

    private void trav(TreeNode node, int depth, String suffix){
        String newSuffix = (char)(node.val + 'a') + suffix;
        if(node.left != null){
            trav(node.left, depth + 1, newSuffix);
        }
        if(node.right != null){
            trav(node.right, depth + 1, newSuffix);
        }
        if(node.left == null && node.right == null){
            if(minLexco == null || newSuffix.compareTo(minLexco) < 0){
                minLexco = newSuffix;
            }
        }
    }
}
