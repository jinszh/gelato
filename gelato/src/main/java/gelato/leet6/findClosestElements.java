package gelato.leet6;

import java.util.*;
import java.util.stream.Collectors;

//658
public class findClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(x <= arr[0]){
            res = Arrays.stream(Arrays.copyOfRange(arr, 0, k)).boxed().collect(Collectors.toList());
        }else if(x >= arr[arr.length - 1]) {
            res = Arrays.stream(Arrays.copyOfRange(arr, arr.length - k, arr.length)).boxed().collect(Collectors.toList());
        }else {
            int id = Arrays.binarySearch(arr, x);
            if(id < 0){
                id = -id - 2;
            }
            int l = id - k >= 0 ? id - k : 0;
            int r = id + k < arr.length ? id + k : arr.length - 1;
            while (r - l >= k){
                if(arr[r] - x >= x - arr[l]){
                    r--;
                }else {
                    l++;
                }
            }
            res = Arrays.stream(Arrays.copyOfRange(arr, l, r + 1)).boxed().collect(Collectors.toList());
        }
        return res;
    }


    //O(logN) method - 相当于binary search一个区间
    public List<Integer> findClosestElements_OLgN(int [] arr, int k, int x) {
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid+k] - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        return Arrays.stream(arr, lo, lo + k).boxed().collect(Collectors.toList());
    }
}
