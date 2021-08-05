package gelato.leet3;

import gelato.model.NestedInteger;

import java.util.ArrayList;
import java.util.List;


public class depthSumInverse {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxLevel = 1;
        int sum = 0;
        for(NestedInteger ni : nestedList) {
            int level = getLevel(ni);
            maxLevel = Math.max(level, maxLevel);
        }
        // System.out.println(maxLevel);
        for(NestedInteger ni : nestedList) {
            sum += getValue(ni, maxLevel);
        }
        return sum;
    }
    private int getValue(NestedInteger ni, int lvl) {
        if (ni == null) {
            return 0;
        } else if (ni.isInteger()) {
            return lvl * ni.getInteger();
        } else {
            int sum = 0;
            for (NestedInteger nii : ni.getList()) {
                sum += getValue(nii, lvl - 1);
            }
            return sum;
        }
    }
    private int getLevel(NestedInteger ni) {
        if (ni == null) {
            return 0;
        } else if (ni.isInteger()) {
            return 1;
        } else {
            int level = 0;
            for (NestedInteger nii : ni.getList()) {
                level = Math.max(level, 1 + getLevel(nii));
            }
            return level;
        }
    }

    //Shorter version 没有记录depth也不用相乘
    public int depthSumInverse_shorter(List<NestedInteger> nestedList) {
        int unweighted = 0, weighted = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger())
                    unweighted += ni.getInteger();//之前的level的会被反复加上去, 相当于乘上了depth var
                else
                    nextLevel.addAll(ni.getList());
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }
}
