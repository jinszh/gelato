package gelato.leet2;

import java.util.ArrayList;
import java.util.List;

//271
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        sb.append(strs.size()+",");
        for(String s : strs) {
            sb.append(s.length() + ",");
        }
        for(String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        char [] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (cs[i++] != ','){
            sb.append(cs[i - 1]);
        }
        int size = Integer.parseInt(sb.toString());
        int [] len = new int[size];
        int j = 0;
        while (j < size){
            sb = new StringBuilder();
            while (cs[i++] != ','){
                sb.append(cs[i - 1]);
            }
            len[j++] = Integer.parseInt(sb.toString());
        }
        List<String> res = new ArrayList<>(size);
        j = 0;
        while (j < size){
            sb = new StringBuilder();
            int k = 0;
            while (k < len[j]){
                sb.append(cs[i++]);
                k++;
            }
            res.add(sb.toString());
            j++;
        }
        return res;
    }

    //其实就是一个length, 不需要写那么长的... 直接用substring比用sb一个拼char来的快,程序短
    public String encode2(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode2(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            i = slash + size + 1;
            ret.add(s.substring(slash + 1, i));
        }
        return ret;
    }
}
