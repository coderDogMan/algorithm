package week.week.year2023;

public class 打家劫舍III337 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    // 0 不选 1 选
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] res = new int[]{0, 0};
        int[] leftRes = dfs(root.left);
        int[] rightRes = dfs(root.right);
        res[0] = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
        res[1] = leftRes[0] + rightRes[0] + root.val;
        return res;
    }
}
