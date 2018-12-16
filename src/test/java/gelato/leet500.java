package gelato;

import gelato.lee500.FreedomTrail;
import gelato.lee500.IPO;
import gelato.lee500.SuperWashingMachines;
import gelato.lee500.WordAbbreviation;
import gelato.util.Trie;
import gelato.util.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leet500 extends LeetTests {
    @Test
    public void testIPO(){
        IPO f = new IPO();
//        String[] paras = Util.readFromFile("IPO");
//        int v = f.findMaximizedCapital(50000, 50000
//                , Util.getOneDArray(paras[0]), Util.getOneDArray(paras[1]));
        int v = f.findMaximizedCapital(2,0, Util.getOneDArray("[1,2,3]"), Util.getOneDArray("[0,1,1]"));
        Util.print(v);
    }

    @Test
    public void testFreedomTrail(){
        FreedomTrail f = new FreedomTrail();
        int v = f.findRotateSteps("godding", "godding");
        Util.print(v);
    }

    @Test
    public void testWordAbbreviation(){
        WordAbbreviation f = new WordAbbreviation();
        List l = Arrays.asList(Util.get1dStr("[\"like\",\"god\",\"internal\",\"me\",\"internet\",\"interval\",\"intension\",\"face\",\"intrusion\"]"));
        List<String> v = f.wordsAbbreviation(l);
        Util.print(v);
    }

    @Test
    public void testSuperWashingMachines(){
        SuperWashingMachines f = new SuperWashingMachines();
       int v = f.findMinMoves(Util.getOneDArray("[0,0,14,0,10,0,0,0]"));
        Util.print(v);
    }
}
