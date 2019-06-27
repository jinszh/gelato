package gelato.leet2;

//255
public class verifyPreorder {
    //其实确定一个单向的low就可以了
    //题目说了constant space就不要用递归!
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low)
                return false;
            while (i >= 0 && p > preorder[i])
                low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }
}
