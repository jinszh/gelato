package gelato.leet7;

import java.util.ArrayList;
import java.util.List;

//722
public class removeComments {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            if (source[i].contains("/*")
                    && !(source[i].contains("//") && source[i].indexOf("//") < source[i].indexOf("/*"))) {
                String rem = source[i].substring(0, source[i].indexOf("/*"));
                source[i] = source[i].substring(source[i].indexOf("/*") + 2);
                while (!source[i].contains("*/")) {
                    i++;
                }
                rem += source[i].substring(source[i].indexOf("*/") + 2);
                if (!rem.equals("")) {
                    source[i] = rem;
                    i--;
                }
            } else if (source[i].contains("//")) {
                if (!source[i].startsWith("//")) {
                    res.add(source[i].substring(0, source[i].indexOf("//")));
                }
            } else {
                res.add(source[i]);
            }
        }
        return res;
    }

    //一个个char才是真正的one-pass, O(n)
    public List<String> removeComments_ON(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (mode) {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        mode = false;
                        i++;        //skip '/' on next iteration of i
                    }
                }
                else {
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;      //ignore remaining characters on line s
                    }
                    else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        mode = true;
                        i++;           //skip '*' on next iteration of i
                    }
                    else    sb.append(s.charAt(i));     //not a comment
                }
            }
            if (!mode && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();   //reset for next line of source code
            }
        }
        return res;
    }
}
