package tree.easy;

import java.util.Objects;

public class 相同的树100 {
    public static void main(String[] args) {
        boolean sameTree = isSameTree(new TreeNode(), new TreeNode());
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }

}
