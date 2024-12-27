package tree.mid;

import java.util.ArrayList;
import java.util.List;

public class 路径总和II113 {

    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();
    private static int sum;


    public static void main(String[] args) {
        List<List<Integer>> list = pathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 3);
        System.out.println(list);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traversal(root, targetSum);
        return res;
    }

    public static void traversal(TreeNode root, int targetSum) {
        if (root == null) return;
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) res.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            traversal(root.left, targetSum);
            sum -= root.left.val;
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, targetSum);
            sum -= root.right.val;
            path.remove(path.size() - 1);
        }
    }
}
