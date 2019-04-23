package gelato;

import gelato.leet8.*;
import gelato.util.Util;
import org.junit.Test;

public class lee8 extends LeetTests{
    @Test
    public void test875() {
        minEatingSpeed t = new minEatingSpeed();
        int n = t.minEatingSpeed_my(Util.getOneDArray("\n" +
                "[142126477]"), 142126479);
        print(n);
    }
}
