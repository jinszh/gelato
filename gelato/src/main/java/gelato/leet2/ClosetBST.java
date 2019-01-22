package gelato.leet2;

import gelato.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ClosetBST {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> arr = new ArrayList<>();
        if (root != null) {
            LinkedList<Integer> trav = new LinkedList<>();
            int pos = -1;
            Stack<TreeNode> t = new Stack<>();
            t.push(root);
            while (!t.empty()) {
                TreeNode h = t.peek();
                if (h.left != null) {
                    t.push(h.left);
                } else if (h.right != null) {
                    pos = addWithCheck(trav, target, h, pos);
                    t.push(h.right);
                } else {
                    h = t.pop();
                    pos = addWithCheck(trav, target, h, pos);
                    while (!t.empty() &&(t.peek().right == h || (t.peek().left == h && t.peek().right == null))) {
                        if (t.peek().left == h) {
                            pos = addWithCheck(trav, target, t.peek(), pos);
                        }
                        h = t.pop();
                    }
                    if (!t.empty() && t.peek().right != null) {
                        pos = addWithCheck(trav, target, t.peek(), pos);
                        t.push(t.peek().right);
                    }
                }
            }
            if (pos > 0) {
                int low, high;
                if (k % 2 == 1) {
                    int left = pos - 1 - k / 2;
                    int right = pos + k / 2;
                    low = left < 0 ? 0 : ( right >= trav.size() ? trav.size() - k
                            : (Math.abs(trav.get(left) - target) < Math.abs(trav.get(right) - target) ? left : left + 1));
                    high = right >= trav.size() ? trav.size() : (left < 0 ? k
                            :(Math.abs(trav.get(left) - target) < Math.abs(trav.get(right) - target) ? right : right + 1));
                } else {
                    low = pos - k / 2;
                    high = pos + k / 2;
                }
                arr = trav.subList(low < 0 ? 0 : (high > trav.size() ? trav.size() - k : low)
                        , high > trav.size() ? trav.size() : (low < 0 ? k : high));
            } else if (trav.size() > 0) {
                arr = trav.get(0) >= target ? trav.subList(0, k) : trav.subList(trav.size() - k, trav.size());
            }
        }
        return arr;
    }

    private int addWithCheck(LinkedList<Integer> trav, double target, TreeNode h, int p) {
        if (p < 0 && (trav.size() > 0 && trav.getLast() < target) && h.val >= target) {
            p = trav.size();
        }
        trav.add(h.val);
        return p;
    }
}
