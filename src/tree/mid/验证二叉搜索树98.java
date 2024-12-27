package tree.mid;

import javax.xml.soap.Node;

public class 验证二叉搜索树98 {

    private TreeNode prev;

    public static void main(String[] args) {

    }

    // 左右 中
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (prev != null && prev.val >= root.val) return false;
        prev = root;
        boolean right = isValidBST(root.right);
        return left && right;

    }
}
