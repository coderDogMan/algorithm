package tree.easy;

public class 左叶子之和404 {
    private static int res;
    public static void main(String[] args) {

    }
    //左右中
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) return 0;

        int leftNmu = 0;
        int rightNmu = 0;
        leftNmu = sumOfLeftLeaves(root.left);


        rightNmu = sumOfLeftLeaves(root.right);
        if (root.left != null && root.left.left == null && root.left.right == null) leftNmu = root.left.val;
        return leftNmu + rightNmu;
    }
}
