package tree.mid;

public class 最大二叉树654 {
    public static void main(String[] args) {
//        TreeNode treeNode = constructMaximumBinaryTree(new int[]{3, 2, 1});
        TreeNode treeNode = constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});

    }

    public static TreeNode  constructMaximumBinaryTree(int[] nums) {
        TreeNode root = traversal(nums, 0, nums.length);
        return root;
    }

    public static TreeNode traversal(int[] nums, int left, int right) {
        if (left >= right) return null;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = left; i < right; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = traversal(nums, left, maxIndex);
        root.right = traversal(nums, maxIndex + 1, right);
        return root;
    }


}
