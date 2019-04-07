package gelato;

import gelato.leet10.BinarySubString;
import gelato.leet10.NxtLargerNode;
import gelato.leet10.baseNeg2;
import gelato.leet10.numEnclaves;
import gelato.util.Trie;
import gelato.util.Util;
import org.junit.Test;

public class lee10 extends LeetTests {
    @Test
    public void test1020() {
        numEnclaves t = new numEnclaves();
        int n = t.numEnclaves(Util.getTwoDMatrix("[[0,0,0,1,1,1,0,1,0,0],[1,1,0,0,0,1,0,1,1,1],[0,0,0,1,1,1,0,1,0,0],[0,1,1,0,0,0,1,0,1,0],[0,1,1,1,1,1,0,0,1,0],[0,0,1,0,1,1,1,1,0,1],[0,1,1,0,0,0,1,1,1,1],[0,0,1,0,0,1,0,1,0,1],[1,0,1,0,1,1,0,0,0,0],[0,0,0,0,1,1,0,0,0,1]]"));
        print(n);
    }

    @Test
    public void test1019() {
        NxtLargerNode t = new NxtLargerNode();
        int [] n = t.nextLargerNodes(Util.getTestListNode(new int[]{1,7,5,1,9,2,5,1}));
        print(n);
    }

    @Test
    public void test1017() {
        baseNeg2 t = new baseNeg2();
        String n = t.baseNeg2(0);
        print(n);
    }

    @Test
    public void test1016() {
        BinarySubString t = new BinarySubString();
        boolean n = t.queryString("10010111100001110010",10);
        print(n);
    }
}
