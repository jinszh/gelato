package gelato.leet2;

import java.util.ArrayList;
import java.util.List;

public class strobe2 {
    public int strobogrammaticInRange(String low, String high) {

        int lo = low.length();
        int hi = high.length();

        List<String> all = new ArrayList<>();

        for (int i = lo; i <= hi; i++){
            for (String num : strobHelper(i, i)){
                if (inBounds(low, high, num) ){
                    all.add(num);
                }
            }
        }

        return all.size();
    }

    boolean inBounds(String low, String high, String num){
        if (num.length() < low.length() || num.length() > high.length())
            return false;
        if((num.length() == low.length()&&num.compareTo(low) < 0 )
                ||(num.length() == high.length() && num.compareTo(high) > 0))
            return false;


        return true;
    }


    List<String> strobHelper(int n, int length){
        List<String> sol = new ArrayList<>();

        if (n == 0){
            sol.add("");
            return sol;
        }
        if (n == 1){
            sol.add("0");
            sol.add("1");
            sol.add("8");
            return sol;
        }

        List<String> middles = strobHelper(n-2, length);

        for(String middle:  middles){
            if (n != length){
                sol.add("0" + middle + "0");
            }

            sol.add("8" + middle + "8");
            sol.add("1" + middle + "1");
            sol.add("6" + middle + "9");
            sol.add("9" + middle + "6");
        }

        return sol;
    }

}
