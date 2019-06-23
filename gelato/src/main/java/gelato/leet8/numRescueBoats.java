package gelato.leet8;

import java.util.Arrays;

//881
public class numRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while (r > l) {
            if (people[l] + people[r] <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
            res++;
        }
        if (r == l) res++;
        return res;
    }
}
