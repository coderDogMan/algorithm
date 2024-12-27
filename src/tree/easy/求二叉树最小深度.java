package tree.easy;

public class 求二叉树最小深度 {
    static int min = 0;

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1,
//                new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), null)),
//                new TreeNode(3, new TreeNode(6), null));
//
//        int deep = 0;
//        dfs(deep, treeNode);
//        System.out.println(min);
//        System.out.println(1 % 2760);
        System.out.println(10 * 10* 10* 10* 10 % 35);
    }

    private static void dfs(int deep, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        deep++;
        if (treeNode.left == null && treeNode.right ==null) {
            if (min == 0 || deep < min)
                min = deep;
        }
        dfs(deep, treeNode.left);
        dfs(deep, treeNode.right);
    }
}

