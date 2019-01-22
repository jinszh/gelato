package gelato;

import gelato.lee500.*;
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
    public void testRemoveBoxes(){
        RemoveBoxes f = new RemoveBoxes();
        int v = f.removeBoxes(Util.getOneDArray("[3,3,4,3,4,4,4]"));
        Util.print(v);
    }

    @Test
    public void testStudentAttendanceRecordII(){
        StudentAttendanceRecordII f = new StudentAttendanceRecordII();
        int v = f.checkRecord(2);
        Util.print(v);
    }

    @Test
    public void testClosestParlindrome(){
        ClosestParlindrome f = new ClosestParlindrome();
        String v = f.nearestPalindromic("1325060231");
        Util.print(v);
    }

    @Test
    public void testMaximumVacationDays(){
        MaximumVacationDays f = new MaximumVacationDays();
        String[] paras = Util.readFromFile("maxVacation");
        int v = f.maxVacationDays(Util.getTwoDMatrix(paras[0])
                , Util.getTwoDMatrix(paras[1]));
        Util.print(v);
    }

    @Test
    public void testSuperWashingMachines(){
        SuperWashingMachines f = new SuperWashingMachines();
       int v = f.findMinMoves(Util.getOneDArray("[0,0,14,0,10,0,0,0]"));
        Util.print(v);
    }

    @Test
    public void testTagValidator(){
        TagValidator f = new TagValidator();
        boolean v = f.isValid("<A><![CDATA[</A>]]123></A>");
        Util.print(v);
    }

    @Test
    public void testNonNegativeIntNoConsecutiveOnes(){
        NonNegativeIntNoConsecutiveOnes f = new NonNegativeIntNoConsecutiveOnes();
        int v = f.findIntegers(8);
        Util.print(v);
    }
}
