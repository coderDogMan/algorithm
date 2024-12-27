package tree.easy;

public class 合并二叉树617 {
    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        else if (root1 != null && root2 != null) {
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
        }
        else if (root1 != null && root2 == null) {
            root1.left = mergeTrees(root1.left, null);
            root1.right = mergeTrees(root1.right, null);
        }
        else if (root1 == null && root2 != null) {
            root1 = root2;
            root1.left = mergeTrees(root2.left, null);
            root1.right = mergeTrees(root2.right, null);
        }

        return root1;
    }

}
