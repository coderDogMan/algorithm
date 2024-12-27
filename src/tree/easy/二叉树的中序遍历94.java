package tree.easy;


import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历94 {
    public static void main(String[] args) {
        inorderTraversal(new TreeNode(1, null, new TreeNode(2,new TreeNode(3),null)));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private static void dfs(TreeNode root, int deep, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        deep++;
        dfs(root.left,deep, list);
        list.add(root.val);
        dfs(root.right,deep, list);

    }


}
