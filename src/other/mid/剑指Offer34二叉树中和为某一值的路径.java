package other.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 剑指Offer34二叉树中和为某一值的路径 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        traversal(root, target);
        return ans;
    }

    public void traversal(TreeNode root, int target) {
        if (root == null) {
            if (target == 0) {
                ans.add(new ArrayList<Integer>(path));
            }
            return;
        }
        path.add(root.val);
        traversal(root.left, target - root.val);
        traversal(root.right, target - root.val);
        path.removeLast();
    }
}
class Test {
    public static void main(String[] args) {
        剑指Offer34二叉树中和为某一值的路径 test = new 剑指Offer34二叉树中和为某一值的路径();
//        test.pathSum(new int[]{1,6,3,2,5});
//        new Sc
    }
}
