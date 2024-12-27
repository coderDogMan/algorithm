package tree.easy;

public class 路径总和112 {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && targetSum - root.val == 0) return true;
        if (root.left == null && root.right == null ) return false;

        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        return  left || right;
    }
}
