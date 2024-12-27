package tree.mid;

public class 二叉搜索树的最近公共祖先235 {
    public static void main(String[] args) {
        TreeNode treeNode = lowestCommonAncestor(new TreeNode(6, new TreeNode(2), new TreeNode(8)), new TreeNode(2), new TreeNode(4));
        System.out.println(treeNode);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val){
            root = lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val){
            root = lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
