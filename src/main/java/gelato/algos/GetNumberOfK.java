package gelato.algos;

//有序数组 二分查找 - 计算有序数组中k出现的次数
// 因为要查找的是k的起始坐标和结束坐标, 就可以算出k出现的次数
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int l = biSearch(array, k - 0.5);
        int r = biSearch(array, k + 0.5);
        return r - l;
    }

    private int biSearch(int [] array, double k) {
        int l = 0, r = array.length - 1;
        int pos = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if(array[m] > k) {
                pos = m - 1;
            }else{
                pos = m;
            }
            if (array[m] < k) {
                l = m + 1;
            } else if (array[m] > k) {
                r = m - 1;
            } else if (array[m] == k) {
                break;
            }
        }
        return pos;
    }
}
