package gelato.leet9;

import java.util.HashMap;

public class countTriplets {
    //O(N^3) version
    public int countTriplets(int[] A) {
        int res = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = i; j < A.length; j++){
                for(int k = j; k < A.length; k++){
                    if((A[i] & A[j] & A[k]) == 0){
                        if(i== j && j == k){
                            res ++;
                        }else if(i == j || k == j || i == k){
                            res += 3;
                        }else {
                            res += 6;
                        }
                    }
                }
            }
        }
        return res;
    }

    //Hash map version:  O(N * 1 << 16) 在N很大时候可能有提升
    public int countTriplets_v2(int[] A) {
        int res = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                hmap.put(A[i] & A[j], hmap.getOrDefault(A[i] & A[j], 0) + 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (Integer key : hmap.keySet()) {
                if ((A[i] & key) == 0){
                    res += hmap.get(key);
                }
            }
        }
        return res;
    }
}
