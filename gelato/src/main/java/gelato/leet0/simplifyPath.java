package gelato.leet0;

import java.util.*;
import java.util.stream.Collectors;

//71
public class simplifyPath {
    public String simplifyPath(String path) {
        path += "/";
        Deque<String> stack = new LinkedList<>();
        int i = 0;
        while (i < path.length()) {
            int pre = i;
            i = path.indexOf("/", i);
            if (pre < i) {
                String sub = path.substring(pre, i);
                if (sub.equals("..")) {
                    if(!stack.isEmpty()) {
                        stack.pollLast();
                    }
                } else if (sub.equals(".")) {
                    continue;
                } else {
                    stack.add(sub);
                }
            }
            i++;
        }
        return "/" + stack.stream().collect(Collectors.joining("/"));
    }


    //用split比substring的方法快很多
    public String simplifyPath2(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
}
