package tree.easy;

public class 对称二叉树101 {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    public static boolean dfs(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;

        return dfs(l.left,r.right) && dfs(l.right,r.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left.val != right.val) return false;
        return check(left.left, right.right) && check(left.right, right.left);
    }


}
