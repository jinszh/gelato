package gelato.leet2;

import java.util.ArrayList;
import java.util.List;

public class strobogrammaticInRange {
    public int strobogrammaticInRange(String low, String high) {
        return getNum(low, high);
    }

    private int getNum(String n1, String n2) {
        int cnt = 0;
        String[] valid = new String[]{"","0","1","8"};
        boolean lenReached = false;
        while (!lenReached) {
            List<String> newValid = new ArrayList<>();
            for (int i = 0; i < valid.length; i++) {
                if ((valid[i].compareTo("0") == 0 || !valid[i].startsWith("0"))
                        && compare(valid[i], n2) <= 0
                        && compare(valid[i], n1) >= 0) {
                    cnt++;
                }
                if (valid[i].length() <= n2.length() - 4) {
                    newValid.add("0" + valid[i] + "0");
                }
                if (valid[i].length() <= n2.length() - 2) {
                    newValid.add("1" + valid[i] + "1");
                    newValid.add("8" + valid[i] + "8");
                    newValid.add("6" + valid[i] + "9");
                    newValid.add("9" + valid[i] + "6");
                }
            }
            if (valid[valid.length - 1].length() >= n2.length()) {
                lenReached = true;
            }
            valid = newValid.toArray(new String[newValid.size()]);
        }
        return cnt;
    }

    private int compare(String v1, String v2){
        return v1.length() > v2.length() ? 1 : (v1.length() == v2.length() ? v1.compareTo(v2) : -1);
    }
}
