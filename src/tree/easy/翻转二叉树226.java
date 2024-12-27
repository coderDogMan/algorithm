package tree.easy;

import javax.xml.soap.Node;

public class 翻转二叉树226 {
    public static void main(String[] args) {
        invertTree(new TreeNode(1,new TreeNode(2),null));

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }

}
