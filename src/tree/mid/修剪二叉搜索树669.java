package tree.mid;

public class 修剪二叉搜索树669 {
    public static void main(String[] args) {

    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) root = trimBST(root.right, low, high);
        else  if (root.val > high) root =  trimBST(root.left, low, high);
        else {
            root.left =  trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;

    }
}
