package gelato.leet2;

//275
public class hIndex2 {
    public int hIndex(int[] citations) {
        int i = 0;
        while (i < citations.length && citations[i] < citations.length - i) i++;
        return citations.length - i;
    }
    //O(logN) - binary search
    public int hIndex_bi(int[] citations) {
        int l =0 , r = citations.length - 1;
        while (l < r){
            int mid = l + (r - l) / 2;
            if(citations[mid] < citations.length - mid){
                l = mid + 1;
            }else if(citations[mid] > citations.length - mid){
                if(mid > 0 && citations[mid - 1] >= citations.length - mid + 1){
                    r = mid - 1;
                }else {
                    l = mid;
                    break;
                }
            }else {
                l = mid;
                break;
            }
        }
        return citations.length - l;
    }

}
