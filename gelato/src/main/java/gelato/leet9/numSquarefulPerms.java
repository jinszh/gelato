package gelato.leet9;

import java.util.*;

public class numSquarefulPerms {
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        boolean [] pused = new boolean[A.length];
        boolean [][] edges = new boolean[A.length][A.length];
        boolean [][] eused = new boolean[A.length][A.length];
        for(int i = 0 ; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                int sqrt = (int)Math.sqrt(A[i] + A[j]);
                if(sqrt * sqrt == A[i] + A[j]){
                    edges[i][j] = edges[j][i] = true;
                }
            }
        }
        Set<String> set = new HashSet<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] == A[i - 1]) continue;
            pused[i] = true;
            stack.add(i);
            while (!stack.isEmpty()) {
                int top = stack.peekLast();
                for (int j = 0; j < A.length; j++) {
                    if (!pused[j] && !eused[top][j] && edges[top][j]) {
                        stack.add(j);
                        pused[j] = eused[top][j] = true;
                        break;
                    }
                }
                if (stack.size() == A.length) {
                    set.add(get(stack, A));
                    //Util.print(get(stack, A));
                }
                if (stack.size() == A.length || top == stack.peekLast()) { //no new
                    top = stack.pollLast();
                    pused[top] = false;
                    for (int k = 0; k < A.length; k++) {
                        if (eused[top][k]) {
                            eused[top][k] = false;
                        }
                    }
                }
            }
            pused[i] = false;
        }
        return set.size();
    }
    private String get(LinkedList<Integer> l, int [] A){
        String res = "";
        for (Integer it: l) {
            res += A[it] + "#";
        }
        return res + "\n";
    }

    // --------------------- 华丽的分割线 -------------------------------------
    // 优化的版本 - 直接用递归实现DFS, 加一个cntMap来统计个数
    //能用map的时候不要自己去用edge矩阵

    Map<Integer, Integer> cntMap = new HashMap<>();
    Map<Integer, Set<Integer>> squareMap = new HashMap<>();
    int cnt = 0;
    public int numSquarefulPerms_opt(int[] A) {
        for (int num : A) {
            if (!cntMap.containsKey(num)) {
                cntMap.put(num, 1);
                squareMap.put(num, new HashSet<>());
            } else {
                cntMap.put(num, cntMap.get(num) + 1);
            }
        }
        for (int num1 : cntMap.keySet()) {
            for (int num2 : cntMap.keySet()) {
                double c = Math.sqrt(num1 + num2);
                if (c == Math.floor(c)) {
                    squareMap.get(num1).add(num2);
                    squareMap.get(num2).add(num1);
                }
            }
        }
        for (int num: cntMap.keySet()) {
            countPerm(num, A.length - 1);
        }
        return cnt;
    }

    private void countPerm(int num, int left) {
        cntMap.put(num, cntMap.get(num) - 1);
        if (left == 0) { cnt++; }
        else {
            for (int next : squareMap.get(num)) {
                if (cntMap.get(next) != 0) {
                    countPerm(next, left - 1);
                }
            }
        }
        cntMap.put(num, cntMap.get(num) + 1);
    }
}
