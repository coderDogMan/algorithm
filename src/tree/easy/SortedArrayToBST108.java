package tree.easy;

public class SortedArrayToBST108 {
    public static void main(String[] args) {
        TreeNode treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});


    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode build = build(nums, 0, nums.length - 1);
        return build;
    }

    private static TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, l, mid - 1);
        root.right = build(nums, mid + 1, r);
        return root;
    }
}



