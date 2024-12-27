package tree.mid;

public class 完全二叉树的节点个数222 {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDeep = 0, rightDeep = 0;
        TreeNode left = root.left, right = root.right;
        while (left != null) {
            leftDeep++;
            left = left.left;
        }
        while (right != null) {
            rightDeep++;
            right = right.right;
        }
        if (leftDeep == rightDeep) {
            return (2 << rightDeep) - 1;
        }
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        return leftNum + rightNum + 1;
    }
}
