package gelato;

import gelato.leet1.*;
import gelato.util.Util;
import org.junit.Test;

public class lee1 extends LeetTests{
    @Test
    public void test152(){
        maxProduct f = new maxProduct();
        int v = f.maxProduct(Util.getOneDArray("[-9]"));
        Util.print(v);
    }
}
