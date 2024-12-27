package tree.mid;

public class 二叉树的最近公共祖先236 {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        root.left = lowestCommonAncestor(root.left, p, q);
        root.right = lowestCommonAncestor(root.right, p, q);
        if (root.left != null && root.right != null) return root;
        else if (root.left != null) {return root.left;}
        else if (root.right != null) {return root.right;}
        return null;
    }
}
