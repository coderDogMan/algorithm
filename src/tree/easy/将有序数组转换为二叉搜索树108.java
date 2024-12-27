package tree.easy;

public class 将有序数组转换为二叉搜索树108 {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = createTree(nums, 0, nums.length);
        return root;
    }

    public TreeNode createTree(int[] nums, int left, int right) {
        if (left >= right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createTree(nums, left, mid);
        node.right = createTree(nums, mid + 1, right);
        return node;
    }
}
