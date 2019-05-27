package gelato;

import gelato.leet0.*;
import gelato.leet1.flatten;
import gelato.model.TreeNode;
import gelato.util.Util;
import org.junit.Test;

import java.util.LinkedList;

public class lee0 extends LeetTests{
    @Test
    public void test056(){
        merge f = new merge();
        Util.print(f.merge(Util.getTwoDMatrix("[[0,4],[1,4]]")));
    }
}
