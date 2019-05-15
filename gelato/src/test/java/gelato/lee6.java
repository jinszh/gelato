package gelato;

import gelato.model.TreeNode;
import gelato.util.Util;
import org.junit.Test;
import gelato.leet6.*;

import java.util.List;

public class lee6 extends LeetTests {
    @Test
    public void test654() {
        constructMaximumBinaryTree t = new constructMaximumBinaryTree();
        TreeNode n = t.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        Util.print(n);
    }

    @Test
    public void test692() {
        topKFrequent t = new topKFrequent();
        List n = t.topKFrequent(Util.get1dStr("[\"i\", \"love\", \"leetcode\", \"i\", \"love\", \"coding\"]"), 2);
        Util.print(n);
    }
}
