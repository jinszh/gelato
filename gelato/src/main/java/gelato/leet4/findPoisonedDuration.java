package gelato.leet4;

//495
public class findPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int end = 0;
        for (int i = 0 ; i < timeSeries.length; i++){
            if(timeSeries[i] < end){
                res += timeSeries[i] - timeSeries[i - 1];
            }else {
                res += duration;
            }
            end = timeSeries[i] + duration;
        }
        return res;
    }
}
