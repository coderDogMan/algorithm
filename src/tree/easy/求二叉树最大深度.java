package tree.easy;

public class 求二叉树最大深度 {
    static int max = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), null)),
                new TreeNode(3, new TreeNode(6), null));

        int deep = 0;
        dfs(deep, treeNode);
        System.out.println(max);

    }

    private static void dfs(int deep, TreeNode treeNode) {
        if (treeNode == null) return;
        deep++;
        if (treeNode.right == null && treeNode.left == null)
            max = max > deep ? max : deep;
        dfs(deep, treeNode.left);
        dfs(deep, treeNode.right);
    }


}

