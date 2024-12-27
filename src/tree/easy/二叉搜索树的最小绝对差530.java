package tree.easy;

public class 二叉搜索树的最小绝对差530 {

    private int min = Integer.MAX_VALUE;

    private TreeNode prev;

    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;

        traversal(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        traversal(root.right);

    }
}
