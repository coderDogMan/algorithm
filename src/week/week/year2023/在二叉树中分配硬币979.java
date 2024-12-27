package week.week.year2023;

public class 在二叉树中分配硬币979 {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return dfs(root);
    }
    //返回多的节点
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        res += dfs(root.left);
        res += dfs(root.right);
        ans += Math.abs(root.val - 1 + res);
        return root.val - 1 + res;
    }
}
