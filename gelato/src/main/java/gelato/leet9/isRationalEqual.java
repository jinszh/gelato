package gelato.leet9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class isRationalEqual {
    //笨 ... 要考虑到java的double
    public boolean isRationalEqual(String S, String T) {
        Integer[] src = getParts(S);
        Integer[] tgt = getParts(T);
        return src[0].equals(tgt[0]) && ((src[1] == null && tgt[1] == null) || (src[1] != null && src[1].equals(tgt[1])))
                && ((src[2] == null && tgt[2] == null) || (src[2] != null && src[2].equals(tgt[2])));
    }

    private Integer[] getParts(String s) {
        Integer[] parts = new Integer[3];
        String[] p12 = s.split("\\.");
        parts[0] = Integer.parseInt(p12[0]);
        if (p12.length > 1 && !p12[1].isEmpty()) {
            String nonRepi = p12[1];
            int repid = p12[1].indexOf("(");
            if (repid >= 0) {
                nonRepi = p12[1].substring(0, repid);
                String repi = collapse(p12[1].substring(repid + 1, p12[1].length() - 1));
                while (!nonRepi.isEmpty() && nonRepi.endsWith(repi)) {
                    nonRepi = nonRepi.substring(0, nonRepi.length() - repi.length());
                }
                int tid = 0;
                while (tid < nonRepi.length() && tid < repi.length() && repi.charAt(repi.length() - tid - 1) == nonRepi.charAt(nonRepi.length() - 1 - tid)) {
                    tid++;
                }
                String tail = tid > 0 ? nonRepi.substring(nonRepi.length() - tid, nonRepi.length()) : null;
                if (tail != null) {
                    repi = tail + repi.substring(0, repi.length() - tail.length());
                    nonRepi = nonRepi.substring(0, nonRepi.length() - tail.length());
                }
                parts[2] = repi.equals("0") ? null : Integer.parseInt(repi);
            }
            if (!nonRepi.isEmpty()) {
                if((nonRepi.startsWith("0") &&( parts[2] !=null || Integer.parseInt(nonRepi) != 0)) ||
                        (nonRepi.endsWith("0") && parts[2] != null)){
                    nonRepi = "-1" + nonRepi;
                }
                parts[1] = Integer.parseInt(nonRepi) == 0 && parts[2] == null ? null : Integer.parseInt(nonRepi);
            }
        }
        if(parts[2] != null && parts[2] == 9){
            if(parts[1] != null){
                parts[1] = parts[1] > 0 ? parts[1] + 1 : parts[1] - 1;
                if(parts[1] < 0 && !parts[1].toString().contains("0")){
                    parts[1] = Integer.parseInt(parts[1].toString().substring(2));
                }
            }else {
                parts[0]++;
            }
            parts[2] = null;
        }
        return parts;
    }

    private String collapse(String s) {
        while (s.length() > 1) {
            if (s.length() > 3) {
                if (s.substring(0, 2).equals(s.substring(2, 4))) {
                    s = s.substring(0, 2);
                } else {
                    break;
                }
            } else if (s.length() > 2) {
                if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2)) {
                    s = s.substring(0, 1);
                }
                break;
            } else {
                if (s.charAt(0) == s.charAt(1)) {
                    s = s.substring(0, 1);
                }
                break;
            }
        }
        return s;
    }

    //Brilliant way 1:
    //ratio其实是1.0, 0.111111, 0,01010101010101..., 0,001001001001001.., 0.0001000100010001,就可以模拟循环小数
    private List<Double> ratios = Arrays.asList(1.0, 1.0 / 9, 1.0 / 99, 1.0 / 999, 1.0 / 9999);

    public boolean isRationalEqual_w1(String S, String T) {
        return Math.abs(computeValue(S) - computeValue(T)) < 1e-9;
    }

    private double computeValue(String s) {
        if (!s.contains("(")) {
            return Double.valueOf(s);
        } else {
            double intNonRepeatingValue = Double.valueOf(s.substring(0, s.indexOf('(')));
            int nonRepeatingLength = s.indexOf('(') - s.indexOf('.') - 1;
            int repeatingLength = s.indexOf(')') - s.indexOf('(') - 1;
            int repeatingValue = Integer.parseInt(s.substring(s.indexOf('(') + 1, s.indexOf(')')));
            //比如 0.05(25) --> 0.05 + (25 * 0.01 * 0.0101010101...)
            return intNonRepeatingValue + repeatingValue * Math.pow(0.1, nonRepeatingLength) * ratios.get(repeatingLength);
        }
    }
    //Brilliant way 2: 用double自己去解析
    public boolean isRationalEqual_W2(String S, String T) {
        return f(S) == f(T);
    }

    public double f(String S) {
        int i = S.indexOf('(');
        if (i > 0) {
            String base = S.substring(0, i);
            String rep = S.substring(i + 1, S.length() - 1);
            for (int j = 0; j < 20; ++j) base += rep;
            return Double.valueOf(base);
        }
        return Double.valueOf(S);
    }

}
