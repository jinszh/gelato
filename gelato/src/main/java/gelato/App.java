package gelato;

import gelato.algos.*;
import gelato.leetCode.addTwoNumbers;
import gelato.leetCode.myAtoi;
import gelato.model.ListNode;
import gelato.model.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    }




    private static void reorder(){
        reOrderArray p = new reOrderArray();
        boolean result =  p.IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1});

        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<>();
        Integer v = stack.peek();
        print(v);
    }
    private static void print(Object v){
        System.out.print(v);
    }
}
