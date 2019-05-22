package gelato.leet6;

import java.util.HashMap;
import java.util.List;

//638
public class shoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int need = toInt(needs);
        int[] dp = new int[need + 1];
        dp[0] = 0;
        int [] offerCodes = new int[special.size()];
        for(int i = 0; i < special.size(); i++){
            offerCodes[i] = toInt(special.get(i).subList(0, special.get(i).size() - 1));
        }
        for (int i = 1; i <= need; i++) {
            if(less(i, need)) {
                int minPrice = 0;
                for (int j = 0, cur = i; cur != 0; j++, cur /= 10) {
                    minPrice += price.get(price.size() - 1 - j) * (cur % 10);
                }
                for (int j = 0; j < offerCodes.length; j++) {
                    if (less(offerCodes[j], i) &&
                            (dp[i - offerCodes[j]] + special.get(j).get(special.get(j).size() - 1) < minPrice)) {
                        minPrice = dp[i - offerCodes[j]] + special.get(j).get(special.get(j).size() - 1);
                    }
                }
                dp[i] = minPrice;
            }
        }
        return dp[need];
    }

    private boolean less(int a, int b){
        while (a > 0 && b > 0){
            if(a % 10 > b % 10){
                break;
            }
            a /= 10;
            b /= 10;
        }
        return a == 0;
    }
    private int toInt(List<Integer> items){
        int res = 0;
        for(Integer i : items){
            res *= 10;
            res += i;
        }
        return res;
    }


}
