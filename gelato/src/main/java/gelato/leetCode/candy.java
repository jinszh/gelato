package gelato.leetCode;

public class candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int n = 0;
        for (int i = 0; i < ratings.length; i++) {
            int l = i > 0 ? i - 1 : i;
            candies[i] = 1;
            if (ratings[i] > ratings[l]) {
                candies[i] = candies[l] + 1;
            }
            int ll = l;
            l = i;
            while (ll >= 0 && candies[ll] <= candies[l] && ratings[ll] > ratings[l]){
                candies[ll] = candies[l] + 1;
                l = ll;
                ll--;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            n += candies[i];
        }
        return n;
    }
}
