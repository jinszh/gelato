package gelato.leet5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Codec {
    HashMap<Integer, List<String>> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Integer hashCode = longUrl.hashCode() % 10000;
        List<String> entry = map.getOrDefault(hashCode, new ArrayList<>());
        String res = null;
        for(int i = 0; i < entry.size(); i++){
            if(entry.get(i).equals(longUrl)){
                res = hashCode.toString() + "/" + i;
                break;
            }
        }
        if(res == null) {
            entry.add(longUrl);
            map.put(hashCode, entry);
            res = hashCode.toString() + "/" + (entry.size() - 1);
        }
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String res = null;
        try {
            if(shortUrl.indexOf("/") >= 0) {
                List<String> entry = map.getOrDefault(Integer.parseInt(shortUrl.substring(0, shortUrl.indexOf("/"))), null);
                int idx = Integer.parseInt(shortUrl.substring(shortUrl.indexOf("/") + 1));
                if (entry != null && entry.size() > idx) {
                    res = entry.get(idx);
                }
            }
        }catch (NumberFormatException e){};
        return  res;
    }
}
