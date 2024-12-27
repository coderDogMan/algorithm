package week.week.year2023;

import java.util.HashMap;

public class 二叉树着色游戏1145 {
    HashMap<Integer, TreeNode> faMap;
    int x;
    TreeNode xNode;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        faMap = new HashMap<>();
        this.x = x;
        faDfs(root, null);
        int f = dfs(faMap.get(x), x);
        int l = dfs(xNode.left, x);
        int r = dfs(xNode.right, x);
        return f > n / 2 || l > n / 2 || r > n / 2;
    }

    private int dfs(TreeNode treeNode, int fa) {
        int f = 0, l = 0, r = 0;
        if (faMap.get(treeNode.val) != null && faMap.get(treeNode.val).val != fa)
            f = dfs(faMap.get(treeNode.val) ,treeNode.val);
        if (treeNode.left != null && treeNode.left.val != fa)
            l = dfs(treeNode.left ,treeNode.val);
        if (treeNode.right != null && treeNode.right.val != fa)
            r = dfs(treeNode.right ,treeNode.val);
        return f + l + r + 1;
    }

    private void faDfs(TreeNode root, TreeNode fa) {
        if (root == null) return;
        if (x == root.val) xNode = root;
        faMap.put(root.val, fa);
        faDfs(root.left, root);
        faDfs(root.right, root);
    }
}

class Test15 {
    public static void main(String[] args) {
        二叉树着色游戏1145 test = new 二叉树着色游戏1145();
        test.btreeGameWinningMove(new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(5, new TreeNode(10), new TreeNode(11))), new TreeNode(3, new TreeNode(6), new TreeNode(7))), 11, 3);

    }
}
