package gelato.leet2;

import gelato.util.Util;

public class numberToWords {
    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();

        String[] s1 = new String[]{"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        String[] s2 = new String[]{"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String[] s3 = new String[]{"Twenty ", "Thirty ", "Fourty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        String[] u2 = new String[]{"", "Thousand ", "Million ", "Billion "};
        String ss = Integer.toString(num);
        int i = ss.length() % 3 == 0 ? 3 : ss.length() % 3;
        while (i <= ss.length()) {
            String sub = ss.substring(i > 3 ? i - 3 : 0, i);
            int cur = 0;
            if (sub.length() == 3) {
                if (sub.charAt(0) != '0') {
                    sb.append(s1[sub.charAt(0) - '1']);
                    sb.append("Hundred ");
                }
                cur++;
            }
            if (sub.length() >= 2 && sub.charAt(cur) == '1') {
                sb.append(s2[sub.charAt(cur + 1) - '0']);
            } else {
                if (sub.length() >= 2) {
                    if (sub.charAt(cur) != '0' && sub.charAt(cur) != '1') {
                        sb.append(s3[sub.charAt(cur) - '2']);
                    }
                    cur++;
                }
                if (sub.length() == 1 && sub.charAt(0) == '0') {
                    sb.append("ZERO");
                } else if(sub.charAt(cur) != '0'){
                    sb.append(s1[sub.charAt(cur) - '1']);
                }
            }
            if(Integer.parseInt(sub) > 0) {
                sb.append(u2[(ss.length() - i) / 3]);
            }
            i += 3;
        }
        return sb.toString().trim();
    }
}
