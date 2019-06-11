package gelato;

import gelato.leet3.*;
import gelato.util.Util;
import org.junit.Test;

public class lee3 extends LeetTests{
    @Test
    public void test375() {
        getMoneyAmount f = new getMoneyAmount();
        int v = f.getMoneyAmount(5);
        Util.print(v);
    }

    @Test
    public void test372() {
        superPow f = new superPow();
        int v = f.superPow(3714151, new int[]{4,9,1,4,4});
        Util.print(v);
    }

    @Test
    public void test325() {
        maxSubArrayLen f = new maxSubArrayLen();
        int v = f.maxSubArrayLen(new int[]{},10);
        Util.print(v);
    }

    @Test
    public void test309() {
        maxProfit f = new maxProfit();
        int v = f.maxProfit(new int[]{1,2,3,0,2});
        Util.print(v);
    }
    @Test
    public void test308() {
      //  NumMatrix_SegTree f = new NumMatrix_SegTree(Util.getTwoDMatrix("[[[[2,3],[-3,5]]]"));
        NumMatrix_BITree f = new NumMatrix_BITree(Util.getTwoDMatrix("[\n" +
                "  [3, 0, 1, 4, 2],\n" +
                "  [5, 6, 3, 2, 1],\n" +
                "  [1, 2, 0, 1, 5],\n" +
                "  [4, 1, 0, 1, 7],\n" +
                "  [1, 0, 3, 0, 5]\n" +
                "]"));
        //NumMatrix_BITree f = new NumMatrix_BITree(Util.getTwoDMatrix("[[[[2,3],[-3,5]]]"));
//        f.update(0 , 1, 3);
//        f.update(1 , 1, -3);
//        f.update(0 , 1, 1);
        int v2 = f.sumRegion(2 , 1, 4, 3);
        f.update(3,2,2);
        Util.print(f.sumRegion(2 , 1, 4, 3));
    }
    @Test
    public void test307() {
        NumArray_SegmentTree f = new NumArray_SegmentTree(Util.getOneDArray("[9,-8]"));

//        f.update(4 , 6);
//        f.update(0 , 2);
//        f.update(0 , 9);
////        int v = f.sumRange(4 , 4);
//        f.update(3 , 8);

        int v = f.sumRange(1 , 1);
        Util.print(v);
    }

    @Test
    public void test323() {
        countComponents f = new countComponents();
        Util.print(f.countComponents_my(5, Util.getTwoDMatrix("[[0,1],[1,2],[0,2],[3,4]]")));
        Util.print(f.cnter);
    }
}
