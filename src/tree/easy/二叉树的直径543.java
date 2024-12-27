package tree.easy;



public class 二叉树的直径543 {
    private int maxLen = 0;
    private int minLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traversal(root, 0);
        return (maxLen - minLen + 1) / 2;
    }

    public void traversal(TreeNode root, int len) {
        if (root == null) {
            maxLen = Math.max(maxLen, len);
            minLen = Math.min(minLen, len);
            return;
        }
        traversal(root.left, len + 1);
        traversal(root.right, len - 1);
    }
}
