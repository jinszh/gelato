package gelato.leet6;

import java.util.*;

public class topKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        String [] buckets = new String[words.length + 1];
        HashMap<String, Integer> freq = new HashMap<>();
        for(String word : words){
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : freq.entrySet()){
            if(buckets[entry.getValue()] != null){
                buckets[entry.getValue()] += ("#" + entry.getKey());
            }else {
                buckets[entry.getValue()] = entry.getKey();
            }
        }

        int nans = 0;
        List<String> ans = new ArrayList<String>(k);
        for(int i = words.length; i >= 0 && nans < k; i--){
            if(buckets[i] != null){
                String [] keys = buckets[i].split("#");
                Arrays.sort(keys);
                for(int j = 0 ; j < keys.length && nans < k ; j++, nans++) {
                    ans.add(keys[j]);
                }
            }
        }
        return ans;
    }
}
