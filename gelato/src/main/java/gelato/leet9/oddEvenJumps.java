package gelato.leet9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.TreeMap;

public class oddEvenJumps {
    public int oddEvenJumps(int[] A) {
        int nans = 0;
        int[] oddfar = new int[A.length];
        int[] evenfar = new int[A.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = A.length - 1; i >= 0; i--) {
            Integer floor = map.floorKey(A[i]);
            Integer ceiling = map.ceilingKey(A[i]);
            if(floor != null) {
                evenfar[i] = oddfar[map.get(floor)];
            }else {
                evenfar[i] = i;
            }
            if(ceiling != null) {
                oddfar[i] = evenfar[map.get(ceiling)];
            }else {
                oddfar[i] = i;
            }
            if (oddfar[i] == A.length - 1) {
                nans++;
            }
            map.put(A[i], i);
        }
        return nans;
    }

    public int oddEvenJumps_stackMethod(int[] A) {
        // sort the array in ascending order, if same value encountered, order by index
        int[][] pair = new int[A.length][2];
        for (int i = 0; i < A.length; i++) {
            pair[i] = new int[]{A[i], i};
        }
        Arrays.sort(pair, (o1, o2) -> (o1[0] - o2[0]));
        int[] higher = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        // find next greater, if same, then index smaller
        for (int[] t : pair) {
            int index = t[1];
            while (!stack.isEmpty() && stack.peek() < index) {
                higher[stack.pop()] = index;
            }
            stack.push(index);
        }

        // sort the array in descending order, if same value encountered, order by index
        Arrays.sort(pair, (o1, o2) -> (o2[0] - o1[0]));
        int[] smaller = new int[A.length];
        stack.clear();
        // find next smaller, if same, then index smaller
        for (int[] t : pair) {
            int index = t[1];
            while (!stack.isEmpty() && stack.peek() < index) {
                smaller[stack.pop()] = index;
            }
            stack.push(index);
        }
        boolean[] odd = new boolean[A.length];
        boolean[] even = new boolean[A.length];
        odd[A.length - 1] = true;
        even[A.length - 1] = true;
        int res = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            odd[i] = even[higher[i]];
            even[i] = odd[smaller[i]];
        }
        for (boolean startFromHere : odd) {
            if (startFromHere) {
                res++;
            }
        }
        return res;
    }
}
