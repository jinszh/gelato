package gelato;

import gelato.leet4.*;
import gelato.util.Util;
import org.junit.Test;

import java.util.List;

public class lee4  extends LeetTests{
    @Test
    public void test454() {
        fourSumCount f = new fourSumCount();
        int v = f.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2});
        Util.print(v);
    }

    @Test
    public void test464() {
        canIWin f = new canIWin();
        boolean v = f.canIWin(10, 0);
        Util.print(v);
    }

    @Test
    public void test486() {
        PredictTheWinner f = new PredictTheWinner();
        boolean v = f.PredictTheWinner(Util.getOneDArray("[1, 3, 1]"));
        Util.print(v);
    }
    @Test
    public void test491() {
        findSubsequences f = new findSubsequences();
        List v = f.findSubsequences(new int[]{4,6,7,7});
        Util.print(v);
    }
}
