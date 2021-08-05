package gelato.leet5;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

//553
public class optimalDivision {
    HashMap<Pair<Integer,Integer>, Pair<Float, String>> memomax;
    HashMap<Pair<Integer,Integer>, Pair<Float, String>> memomin;
    public String optimalDivision(int[] nums) {
        memomax = new HashMap<>();
        memomin = new HashMap<>();
        return getMaxOrMin(nums, 0, nums.length - 1, true).getValue();
    }

    private Pair<Float, String> getMaxOrMin(int [] nums, int b, int e, boolean formax){
        if(formax && memomax.containsKey(new Pair<>(b, e))){
            return memomax.get(new Pair<>(b, e));
        }else if(!formax && memomin.containsKey(new Pair<>(b, e))){
            return memomin.get(new Pair<>(b, e));
        }
        Pair<Float, String> res;
        if(b == e) {
            res = new Pair<Float, String>((float)nums[b], Integer.toString(nums[b]));
        }else {
            float maxormin = formax ? 0 : Integer.MAX_VALUE;
            String vstr = "";
            for (int i = b; i < e; i++) {
                Pair<Float, String> left = getMaxOrMin(nums, b, i, true);
                Pair<Float, String> right = getMaxOrMin(nums, i + 1, e, false);
                float tmp = left.getKey() / right.getKey();
                String tmpstr = left.getValue() + "/" + (right.getValue().contains("/") ? "(" + right.getValue() + ")" : right.getValue());
                if (((!formax && tmp < maxormin) || (formax && tmp > maxormin))
                        || (Math.abs(tmp - maxormin) < 1E-10 && tmpstr.length() < vstr.length())) {
                    maxormin = tmp;
                    vstr = tmpstr;
                }
            }
            res = new Pair<>(maxormin, vstr);
        }
        if(formax) {
            memomax.put(new Pair<>(b, e), res);
        }else{
            memomin.put(new Pair<>(b, e), res);
        }
        return res;
    }

    //优化版
    //其实只需要分母尽量大 分子尽量小, 那其实只有一种做法, 就是a1/(a2/a3/4....)
    //递推 两个的话a1/a2 最小, 三个数a1/a2/a3最小
    public String optimalDivision_2(int[] nums) {
        String ret = "";
        if (nums.length == 0) {
            return ret;
        }
        if (nums.length == 1) {
            ret = Integer.toString(nums[0]);
            return ret;
        }
        if (nums.length == 2) {
            ret = Integer.toString(nums[0]) + "/" + Integer.toString(nums[1]);
            return ret;
        }

        ret = Integer.toString(nums[0]) + "/(" + Integer.toString(nums[1]);
        for (int i=2; i<nums.length; i++) {
            ret += "/" + Integer.toString(nums[i]);
        }
        ret += ")";
        return ret;
    }
}

