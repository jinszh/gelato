package gelato;

import gelato.leet7.*;
import gelato.util.Util;
import org.junit.Test;

public class lee7 extends LeetTests{
    @Test
    public void test774() {
        minmaxGasDist t = new minmaxGasDist();
        double n = t.minmaxGasDist(Util.getOneDArray("[1,2,3,4,5,6,7,8,9,10]"), 9);
        print(n);
    }
}
