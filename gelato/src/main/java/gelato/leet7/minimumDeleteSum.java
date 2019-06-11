package gelato.leet7;

import java.util.Arrays;

//712
public class minimumDeleteSum {
    int [][] cost;
    public int minimumDeleteSum(String s1, String s2) {
        cost = new int[s1.length() + 1][s2.length() + 1];
        for(int [] a : cost){
            Arrays.fill(a, -1);
        }
        cost[s1.length()][s2.length()] = 0;
        int sum = 0;
        for(int i = s1.length() - 1; i >= 0; i--){
            sum += s1.charAt(i);
            cost[i][s2.length()] = sum;
        }
        sum = 0;
        for(int i = s2.length() - 1; i >= 0; i--){
            sum += s2.charAt(i);
            cost[s1.length()][i] = sum;
        }
        return getCost(0, 0, s1.toCharArray(), s2.toCharArray());
    }

    private int getCost(int i, int j, char [] s1, char [] s2) {
        if (cost[i][j] >= 0) {
            return cost[i][j];
        }
        int minCost = 0;
        if (s1[i] == s2[j]) {
            minCost = getCost(i + 1, j + 1, s1, s2);
        }else {
            minCost = Math.min(getCost(i + 1, j, s1, s2) + s1[i], getCost(i, j + 1, s1, s2) + s2[j]);
        }
        cost[i][j] = minCost;
        return minCost;
    }
}
