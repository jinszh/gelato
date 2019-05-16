package gelato;

import gelato.leet4.*;
import gelato.util.Util;
import org.junit.Test;

public class lee4  extends LeetTests{
    @Test
    public void test486() {
        PredictTheWinner f = new PredictTheWinner();
        boolean v = f.PredictTheWinner(Util.getOneDArray("[1, 3, 1]"));
        Util.print(v);
    }

    @Test
    public void test464() {
        canIWin f = new canIWin();
        boolean v = f.canIWin(20, 300);
        Util.print(v);
    }
}
