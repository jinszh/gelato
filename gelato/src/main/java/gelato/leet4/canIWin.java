package gelato.leet4;

public class canIWin {
    int [][] dp;
    int desiredTotal = 0;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        dp = new int[maxChoosableInteger][maxChoosableInteger];
        this.desiredTotal = desiredTotal;
        return calc(0, maxChoosableInteger);
    }

    private boolean calc(int b, int e){
        boolean res = false;
        for(int i = 0 ; i < used.length; i++){
            if(!used[i]){
                total += (i + 1);
                if(total >= desiredTotal){
                    res = true;
                }else {
                    res = !calc(total);
                }
                if(res){
                    break;
                }
                total -= (i + 1);
                used[i] = false;
            }
        }
        return res;
    }
}
