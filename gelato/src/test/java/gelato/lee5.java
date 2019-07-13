package gelato;

import gelato.leet5.*;
import gelato.util.Util;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class lee5 extends LeetTests {
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

    @Test
    public void testkInversePairs(){
        kInversePairs kip = new kInversePairs();
        int v =kip.kInversePairs(5, 3);
        Util.print(v);
    }

    @Test
    public void test592(){
        fractionAddition f = new fractionAddition();
        Util.print(f.fractionAddition("1/3 - 1/2"));
    }

    @Test
    public void test583(){
        minDistance f = new minDistance();
        int v =f.minDistance("a", "b");
        Util.print(v);
    }

    @Test
    public void test560(){
        subarraySum f = new subarraySum();
        int v =f.subarraySum(Util.getOneDArray("[1]"), 0);
        Util.print(v);
    }

    @Test
    public void test553(){
        optimalDivision f = new optimalDivision();
        Util.print(f.optimalDivision(Util.getOneDArray("[1000,100,10,2]")));
    }

    @Test
    public void test547(){
        findCircleNum f = new findCircleNum();
        int v =f.findCircleNum(Util.getTwoDMatrix("[[1,1,1],[1,1,1],[1,1,1]]"));
        Util.print(v);
    }

    @Test
    public void test544(){
        findContestMatch f = new findContestMatch();
        Util.print(f.findContestMatch(8));
    }

    @Test
    public void test535(){
        Codec f = new Codec();
        String c =f.encode("https://leetcode.com/problems/design-tinyurl");
        c =f.decode("-85/0");
        Util.print(c);
    }

    @Test
    public void test525(){
        findMaxLength f = new findMaxLength();
        int c =f.findMaxLength(Util.getOneDArray("[0,0,1,0,0,1,1]"));
        Util.print(c);
    }

    @Test
    public void test524(){
        findLongestWord f = new findLongestWord();
        String c =f.findLongestWord("abpcplea"
                , Arrays.asList(Util.get1dStr("[\"ale\",\"apple\",\"monkey\",\"plea\"]")));
        Util.print(c);
    }

    @Test
    public void test523(){
        checkSubarraySum f = new checkSubarraySum();
        String [] inputs = Util.readFromFile("523");
        boolean c =f.checkSubarraySum(Util.getOneDArray(inputs[0]) , Integer.parseInt(inputs[1]));
        Util.print(c);
    }

    @Test
    public void test516(){
        longestPalindromeSubseq f = new longestPalindromeSubseq();
        Util.println(f.longestPalindromeSubseq("abbabba"));
        Util.print(f.cnt);
    }
}
