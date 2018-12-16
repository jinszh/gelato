package gelato.util;

import gelato.model.ListNode;
import gelato.model.TreeNode;


import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Util {
    public static Long timer;
    public static ReentrantLock timerLock = new ReentrantLock();
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
                print("\n");
            }
        }else if(v instanceof int[]){
            for(Object o : (int[])v){
                print(o + " ");
            }
        } else{
            System.out.print(v);
        }
    }

    public static void println(Object v){
        print(v);
        print("\n");
    }

    public static int [] getOneDArray(String s){
        String [] items = s.trim().replace("[","").replace("]", "").split("\\s*,\\s*");
        int [] array = new int[items.length];
        for(int i = 0; i< items.length; i++){
            array[i] = Integer.parseInt(items[i].trim());
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
        TreeNode root = null;
        if(data != null && data.length > 0 && data[0] != null) {
            root = new TreeNode(data[0]);
            Deque<TreeNode> que = new ArrayDeque<>();
            que.push(root);
            int k = 1;
            while (k < data.length){
                TreeNode l = data[k] == null ? null : new TreeNode(data[k]);
                if(l != null){
                    que.offerLast(l);
                }
                TreeNode r = data[k + 1] == null ? null : new TreeNode(data[k + 1]);
                if(r != null){
                    que.offerLast(r);
                }
                TreeNode par = que.pollFirst();
                par.left = l;
                par.right = r;
                k += 2;
            }
        }
        return root;
    }

    public static TreeNode getTestTreeByArray(Integer [] data){
        TreeNode root = null;
        TreeNode [] nodes;
        if(data != null && data.length > 0 && data[0] != null) {
            root = new TreeNode(data[0]);
            nodes = new TreeNode[data.length];
            nodes[0] = root;
            for(int i = 0; i < data.length; i ++){
                TreeNode curNode = nodes[i];
                if(curNode != null) {
                    if (i * 2 + 1 < data.length && data[i * 2 + 1] != null) {
                        curNode.left = new TreeNode(data[i * 2 + 1]);
                        nodes[i * 2 + 1] = curNode.left;
                    }
                    if (i * 2 + 2 < data.length && data[i * 2 + 2] != null) {
                        curNode.right = new TreeNode(data[i * 2 + 2]);
                        nodes[i * 2 + 2] = curNode.right;
                    }
                }
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
