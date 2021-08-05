package gelato.util;

import gelato.model.ListNode;
import gelato.model.TreeNode;


import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.*;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Util {
    public static Long timer;
    public static ReentrantLock timerLock = new ReentrantLock();
    public static ListNode [] getTestListNodes(int [] data){
        ListNode [] res = new ListNode[data.length];
        ListNode prev = null;
        for(int i = 0 ; i< data.length; i++) {
            if(prev == null) {
                prev = new ListNode(data[i]);
            }else{
                prev.next = new ListNode(data[i]);
                prev = prev.next;
            }
            res[i] = prev;
        }
        return res;
    }

    public static ListNode getTestListNode(int [] data){
        ListNode head = null;
        ListNode prev = null;
        for(int i = 0 ; i< data.length; i++) {
            if(prev == null) {
                prev = new ListNode(data[i]);
                head = prev;
            }else{
                prev.next = new ListNode(data[i]);
                prev = prev.next;
            }
        }
        return head;
    }

    public static Point[] toPointList(String vals){
        Point [] re = null;
        ArrayList<Point> pointList = new ArrayList<Point>();
        String [] ps = vals.split("],\\[");
        re = new Point[ps.length];
        for (String s: ps
             ) {
            String si = s.replace("[", "");
            si = si.replace("]", "");
            String [] vs = si.split(",");
            pointList.add(new Point(Integer.parseInt(vs[0]), Integer.parseInt(vs[1])));
        }
        return pointList.toArray(re);
    }

    public static void checkTime(){
        print("now execution time: " + (new Date().getTime() - timer));
    }

    public static void print(Object v){
        if(v instanceof java.util.List){
            for(Object o : (List)v){
                print(o);
                print(",");
            }
            print("\n");
        }else if(v instanceof double[]){
            for(Object o : (double[])v){
                print(o + " ");
            }
        }else if(v instanceof int[]){
            for(Object o : (int[])v){
                print(o + " ");
            }
        }else if(v instanceof int[][]){
            for(Object o : (int[][])v){
                print(o);
                print(" ; ");
            }
        }else if(v instanceof TreeNode){
            print(((TreeNode) v).val);
        }else if(v instanceof  ListNode){
            while (v != null){
                print(((ListNode) v).val);
                print(",");
                v = ((ListNode) v).next;
            }
            println(".");
        }else{
            System.out.print(v);
        }
    }

    public static void println(Object v){
        print(v);
        print("\n");
    }

    public static double [] get1dDoubleArray(String s){
        List<Double> l = get1dList(s, Double.class);
        return l.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public static int [] get1dIntArray(String s){
        List<Integer> l = get1dList(s, Integer.class);
        return l.stream().mapToInt(Integer::intValue).toArray();
    }

    public static <T> List<T> get1dList(String s, Class clazz){
        String [] items = s.trim().replace("[","").replace("]", "").split("\\s*,\\s*");
        List<T> array = new ArrayList<>();
        for(int i = 0; i< items.length; i++){
            if(clazz == Integer.class) {
                array.add((T) (Integer)Integer.parseInt(items[i].trim()));
            }else if(clazz == Double.class){
                array.add((T) (Double) Double.parseDouble(items[i].trim()));
            }
        }
        return array;
    }


    public static Integer [] getOneDIntegerArray(String s){
        String [] items = s.trim().replace("[","").replace("]", "").split("\\s*,\\s*");
        Integer [] array = new Integer[items.length];
        for(int i = 0; i< items.length; i++){
            try {
                array[i] = Integer.parseInt(items[i].trim());
            }catch (NumberFormatException e){
                array[i] = null;
            }
        }
        return array;
    }

    public static String [] readFromFile(String filePath) {
        try {
            InputStream stream = (InputStream)Util.class.getClassLoader().getResource(filePath).getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            return reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> findDiffInList(String a1, String a2){
        List<String> diff = new ArrayList<>();
        String [] s1 = get1dStr(a1);
        String [] s2 = get1dStr(a2);
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        set1.addAll(Arrays.asList(s1));
        set2.addAll(Arrays.asList(s2));
        for(String s : s1){
            if(!set2.contains(s)){
                diff.add(s);
            }
        }
        return diff;
    }

    public static String [] get1dStr(String s) {
        String[] items = s.split(",");
        String[] array = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            array[i] = items[i].replace("[", "").replace("]", "").replace("\"","").replace("'","").trim();
        }
        return array;
    }

    public static TreeNode getTestTree(Integer [] data){
        return getTestTree(data, null)[0];
    }

    public static TreeNode [] getTestTree(Integer [] data, Integer [] interest) {
        if(interest == null){
            interest = new Integer[0];
        }
        TreeNode [] res = new TreeNode[interest == null ? 1 : interest.length + 1];
        TreeNode root = null;
        if (data != null && data.length > 0 && data[0] != null) {
            root = new TreeNode(data[0]);
            for(int i = 0 ; i< interest.length; i++){
                if(root != null && root.val == interest[i]){
                    res[i + 1] = root;
                }
            }
            Deque<TreeNode> que = new ArrayDeque<>();
            que.push(root);
            int k = 1;
            while (k < data.length) {
                TreeNode l = data[k] == null ? null : new TreeNode(data[k]);
                if (l != null) {
                    que.offerLast(l);
                }
                TreeNode r = (k + 1 == data.length || data[k + 1] == null) ? null : new TreeNode(data[k + 1]);
                if (r != null) {
                    que.offerLast(r);
                }
                for(int i = 0 ; i< interest.length; i++){
                    if(l != null && l.val == interest[i]){
                        res[i + 1] = l;
                    }
                    if(r != null && r.val == interest[i]){
                        res[i + 1] = r;
                    }
                }
                TreeNode par = que.pollFirst();
                par.left = l;
                par.right = r;
                k += 2;
            }
        }
        res[0] = root;
        return res;
    }

    public static TreeNode getTestTreeByArray(Integer [] data) {
        TreeNode root = null;
        TreeNode[] nodes;

        if (data != null && data.length > 0 && data[0] != null) {
            root = new TreeNode(data[0]);
            nodes = new TreeNode[data.length];
            nodes[0] = root;
            int lastNotNul = 0;
            for (int i = 1; i < data.length && lastNotNul < data.length; i += 2) {
                nodes[lastNotNul].left = nodes[i] = data[i] == null ? null : new TreeNode(data[i]);
                if (nodes.length > i + 1) {
                    nodes[lastNotNul++].right = nodes[i + 1] = data[i + 1] == null ? null : new TreeNode(data[i + 1]);
                }
                while (lastNotNul < data.length && nodes[lastNotNul] == null) lastNotNul++;
            }
        }
        return root;
    }

    //求最大公约数 - Greatest common divisor
    public static long gcd(long a, long b){
        if (b==0) return a;
        else return gcd(b,a%b);
    }

    //求最小公倍数 - Least common multiple
    public static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }

    public static <T> List<List<T>> get2DList(String in, Class<T> clazz) {
        String[][] dss = get2DObj(in);
        int [][] inss = new int[dss.length][];
        int i = 0;
        List<List<T>> res = new ArrayList(dss.length);
        for (String [] s: dss) {
            List l = new ArrayList(s.length);
            for (String ss : s ) {
                if(clazz.getSimpleName().equals("Integer")) {
                    l.add(Integer.parseInt(ss));
                }else {
                    l.add(ss);
                }
            }
            i++;
            res.add(l);
        }
        return res;
    }

    public static int[][] getTwoDMatrix(String in) {
        String[][] dss = get2DObj(in);
        int [][] inss = new int[dss.length][];
        int i = 0;
        for (String [] s: dss) {
            int j = 0;
            inss[i] = new int[s.length];
            for (String ss : s ) {
                inss[i][j++] = Integer.parseInt(ss);
            }
            i++;
        }
        return inss;
    }

    public static <T> T[][] getTwoDMatrix(String in, Class clazz) {
        String[][] dss = get2DObj(in);
        T[][] inss = null;
        if (dss != null && dss.length > 0) {
            inss = (T[][]) Array.newInstance(clazz, dss.length, dss[0].length);
            int i = 0;
            for (String[] s : dss) {
                int j = 0;
                for (String ss : s) {
                    inss[i][j++] = (T) (Character) ss.charAt(0);
                }
                i++;
            }
        }
        return inss;
    }

    public static char[][] get2Dchars(String in) {
        String[][] dss = get2DObj(in);
        char[][] inss = new char[dss.length][dss[0].length];
        for (int i = 0; i < dss.length; i++) {
            for (int j = 0; j < dss[0].length; j++) {
                inss[i][j] = dss[i][j].charAt(0);
            }
        }
        return inss;
    }

    public static String[][] get2DObj(String in){
        String[] ods = in.replace("\n","").split("]\\s*,\\s*\\[");
        String[][] res = new String[ods.length][];
        int i = 0;
        for (String s : ods) {
            String s2 = s.replace("[", "").replace("]", "");
            String[] items = s2.split(",");
            res[i] = new String[items.length];
            for (int j = 0; j < items.length; j++) {
                items[j] = items[j].replace("'","").replace("\"", "").trim();
                res[i][j] = items[j];
            }
            i++;
        }
        return res;
    };

    public static void printListNode( ListNode n){
        while (n != null) {
            System.out.print(n.val + ",");
            n = n.next;
        }
        System.out.println();
    }

}
