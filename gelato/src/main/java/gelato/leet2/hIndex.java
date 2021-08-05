package gelato.leet2;

import java.util.HashMap;

//274
public class hIndex {
    public int hIndex(int[] citations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : citations){
            int rep = Math.min(citations.length, i);
            map.put(rep, map.getOrDefault(rep, 0) + 1);
        }
        int res = 0, sum = 0;
        for(int i = citations.length; i >= 0; i++){
            sum += map.getOrDefault(i, 0);
            if(sum == i){
                res = i;
                break;
            }
        }
        return res;
    }

    //faster - 不用java得hashmap用更native得数据结构,比如array会更快
    public int hIndex1(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // counting papers for each citation number
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // finding the h-index
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k])
            k--;
        return k;
    }
}
