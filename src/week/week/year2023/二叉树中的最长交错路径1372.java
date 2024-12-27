package week.week.year2023;

public class 二叉树中的最长交错路径1372 {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        // 0 l      1 r
        dfs(root, -1, 0);
        return ans;
    }

    private void dfs(TreeNode root, int on, int sum) {
        if (root == null) return;
        ans = Math.max(ans, sum);
        if (root.left != null) {
            if (on == 1) {
                dfs(root.left, 1,  1);
            } else {
                dfs(root.left, 1, sum + 1);
            }
        }

        if (root.right != null) {
            if (on == 0) {
                dfs(root.right, 0,  1);
            } else {
                dfs(root.right, 0, sum + 1);
            }
        }
    }
}
