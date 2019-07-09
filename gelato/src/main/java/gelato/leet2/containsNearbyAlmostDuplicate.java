package gelato.leet2;

import java.util.*;

//220
public class containsNearbyAlmostDuplicate {
    //方法1: 用treemap 效率O(nlogk)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k < 1) return false;
        TreeSet<Long> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){
            long l = (long) nums[i];

            Long floor = set.floor(l);
            Long ceil = set.ceiling(l);
            //不需要考虑重复的数的情况, 比如[1,4,8,1,2], 假设重复的数距离在k内, 那差值为0 < t, 返回true
            //否则, 能被第二个1影响到的数, 跟第一个1的距离也超过了k, 这时候第一个1已经被加回来了
            // the tricky part I modified to easily understood way.
            if((floor != null && l - floor <= t) ||
                    (ceil != null && ceil - l <= t) )
                return true;

            set.add(l);

            if(i >= k)
                set.remove((long)nums[i -k]);

        }
        return false;
    }

    //方法2: 用bucket - 相当于是bucket hashmap, 每个桶表示为t的一段数, O(n)
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            //判断桶里面是否有数, 以及相邻的桶里面的数与自己桶里面的数的距离
            //一个桶里面最多只有一个数, 否则直接返回true了
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
