package tree.mid;

public class 把二叉搜索树转换为累加树538 {

    private static TreeNode prev;

    public static void main(String[] args) {
        TreeNode treeNode = convertBST(new TreeNode(0, null, new TreeNode(1)));
        System.out.println(treeNode);
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        root.right = convertBST(root.right);
        if (prev != null) {
            root.val += prev.val;
        }
        prev = root;
        root.left = convertBST(root.left);

        return root;

    }
}
