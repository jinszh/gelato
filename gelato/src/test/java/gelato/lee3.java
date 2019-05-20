package gelato;

import gelato.leet2.findKthLargest;
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
    public void test309() {
        maxProfit f = new maxProfit();
        int v = f.maxProfit(new int[]{1,2,3,0,2});
        Util.print(v);
    }

    @Test
    public void test325() {
        maxSubArrayLen f = new maxSubArrayLen();
        int v = f.maxSubArrayLen(new int[]{},10);
        Util.print(v);
    }
}
