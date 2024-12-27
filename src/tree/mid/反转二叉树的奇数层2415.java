package tree.mid;

public class 反转二叉树的奇数层2415 {
    public static void main(String[] args) {

    }

    public static TreeNode reverseOddLevels(TreeNode root) {
       dfs(root.left, root.right, 1);
       return root;
    }

    private static void dfs(TreeNode left, TreeNode right, int depth) {
        if (left == null) return ;
        if (depth % 2 != 0) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        dfs(left.left, right.right, depth + 1);
        dfs(left.right, right.left, depth + 1);
    }

}


