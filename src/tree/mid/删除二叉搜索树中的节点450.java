package tree.mid;

public class 删除二叉搜索树中的节点450 {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
               return root.right;
            } else if(root.left == null && root.right == null) {
                return null;
            } else if(root.left != null && root.right != null) {
                TreeNode left = root.left;
                TreeNode right = root.right;
                TreeNode cur = root.right;
                while (cur.left != null) cur = cur.left;
                cur.left = left;
                return right;
            }
        }
        if (root.val > key)
            root.left = deleteNode(root.left, key);
        if (root.val < key)
            root.right = deleteNode(root.right, key);

        return root;
    }
}
