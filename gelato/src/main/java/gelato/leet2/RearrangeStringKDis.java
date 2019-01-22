package gelato.leet2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RearrangeStringKDis {
    public String rearrangeString(String s, int k) {
        if(k == 0){
            return s;
        }
        PriorityQueue<Integer[]> orders = new PriorityQueue<Integer[]>((o1,o2) -> {
            if(o1[1].compareTo(o2[1]) != 0){
                return Integer.compare(o2[1], o1[1]);
            }else{
                return Integer.compare(o1[0], o2[0]);
            }});

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        for (char c : map.keySet()) {
            orders.offer(new Integer[]{(int) c, map.get(c)});
        }
        boolean fail = false;
        StringBuilder sb = new StringBuilder();
        while (!orders.isEmpty()) {
            Integer[][] round = new Integer[k][];
            int i;
            for (i = 0; i < k && !orders.isEmpty(); i++) {
                Integer[] h = orders.poll();
                sb.append((char) h[0].intValue());
                h[1]--;
                round[i] = h;
            }
            if(i < k && round[0][1] > 0){
                fail = true;
                break;
            }
            for (int j = 0; j < i && round[j][1] > 0; j++) {
                orders.add(round[j]);
            }
        }
        return fail ? "" : sb.toString();
    }

    /**
     * O(n) version from others -- 因为数字一共只有26个, 所以可以直接用数组比较选最大的, 以及统计个数,不需要hash和heap
     * @param str
     * @param k
     * @return
     */
    public String rearrangeString2(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for (int i = 0; i < length; i++) {
            count[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < length; index++) {
            int candidatePos = findValidMax(count, valid, index);
            if (candidatePos == -1) return "";
            count[candidatePos]--;
            valid[candidatePos] = index + k;
            sb.append((char) ('a' + candidatePos));
        }
        return sb.toString();
    }

    private int findValidMax(int[] count, int[] valid, int index) {
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] > max && index >= valid[i]) {
                max = count[i];
                candidatePos = i;
            }
        }
        return candidatePos;
    }
}
