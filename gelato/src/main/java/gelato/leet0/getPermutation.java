package gelato.leet0;

//60
public class getPermutation {
    public String getPermutation(int n, int k) {
        int[] num = new int[n];
        boolean [] used = new boolean[n + 1];
        num[0] = 1;
        for (int i = 1; i < n; i++) {
            num[i] = num[i - 1] * i;
        }
        StringBuilder sb = new StringBuilder();
        int cur = n;
        while (sb.length() < n){
            int d = k / num[cur - 1];
            d = k % num[cur - 1] == 0 ? d : d + 1;
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if (!used[j]) cnt++;
                if(cnt == d){
                    sb.append(j);
                    used[j] = true;
                    break;
                }
            }
            k -= (d - 1) * num[cur - 1];
            cur--;
        }
        return sb.toString();
    }
}
