package gelato.lee500;

import java.util.Stack;

public class TagValidator {
    public boolean isValid(String code) {
        boolean headFound = false;
        Stack<String> tags = new Stack<>();
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '<') {
                if (code.substring(i).startsWith("</")) {
                    int end = code.indexOf('>', i);
                    if (end > 0) {
                        String inner = code.substring(i + 2, end);
                        if (!tags.isEmpty() && tags.peek().equals(inner)
                                && (tags.size() > 1 || end == code.length() - 1)) {
                            tags.pop();
                        }else {
                            return false;
                        }
                        i = end;
                    }
                } else if (code.substring(i).startsWith("<![CDATA[")) {
                    int end = code.indexOf("]]>", i);
                    if(end < i){
                        return false;
                    }
                    i = end + 2;
                } else if (code.substring(i).startsWith("<")) {
                    int end = code.indexOf('>', i);
                    if (end > 0) {
                        String inner = code.substring(i + 1, end);
                        if (inner.matches("[A-Z]{1,9}")) {
                            if (i == 0) {
                                headFound = true;
                            }
                            tags.add(inner);
                        } else {
                            return false;
                        }
                        i = end;
                    }
                }
            }
            if (!headFound) {
                break;
            }
        }
        return headFound && tags.empty();
    }
}
