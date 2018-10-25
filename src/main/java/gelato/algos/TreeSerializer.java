package gelato.algos;

import gelato.model.TreeNode;

import java.util.LinkedList;

public class TreeSerializer {
   public String Serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(root.val).append(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.left != null) {
                sb.append(p.left.val).append(",");
                queue.add(p.left);
            } else {
                sb.append("#,");
            }
            if (p.right != null) {
                sb.append(p.right.val).append(",");
                queue.add(p.right);
            } else {
                sb.append("#,");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).append(']').toString();
    }
    public TreeNode Deserialize(String str) {
        if (str == "[]") {
            return null;
        }
        String trimStr = str.substring(1, str.length() - 1);
        String[] array = trimStr.split(",");
        int k = 0, len = array.length;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(array[k++]));
        queue.add(root);
        while (queue.size() != 0 && k < len) {
            TreeNode p = queue.poll();
            if (k < len && !"#".equals(array[k])) {
                p.left = new TreeNode(Integer.parseInt(array[k]));
                queue.add(p.left);
            }
            k++;
            if (k < len && !"#".equals(array[k])) {
                p.right = new TreeNode(Integer.parseInt(array[k]));
                queue.add(p.right);
            }
            k++;
        }
        return root;
    }
}
