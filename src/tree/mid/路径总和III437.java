package tree.mid;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class 路径总和III437 {
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        traversal(root, targetSum);
        if (root.left != null) {
            pathSum(root.left, targetSum);
        }
        if (root.right != null) {
            pathSum(root.right, targetSum);
        }
        return ans;
    }

    public void traversal(TreeNode root, int targetSum) {
        if (root == null) return;
        targetSum -= root.val;
        if (targetSum == 0) {
            ans++;
        }
        traversal(root.left, targetSum);
        traversal(root.right, targetSum);
    }

}

//class Test {
//    public static void main(String[] args) {
//        路径总和III437 test = new 路径总和III437();
//        TreeNode root = new TreeNode(10,
//                new TreeNode(5,
//                        new TreeNode(3,
//                                new TreeNode(3), new TreeNode(-2)),
//                        new TreeNode(2, new TreeNode(1), null)), new TreeNode(-3, null, new TreeNode(11)));
//        System.out.println(test.pathSum(root, 8));
//    }
//}