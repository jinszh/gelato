package gelato;

import gelato.model.TreeNode;
import gelato.util.Util;
import org.junit.Test;
import gelato.leet6.*;

public class lee6 extends LeetTests {
    @Test
    public void test654() {
        constructMaximumBinaryTree t = new constructMaximumBinaryTree();
        TreeNode n = t.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        Util.print(n);
    }

}
