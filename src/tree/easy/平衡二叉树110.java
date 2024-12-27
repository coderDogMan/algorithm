package tree.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class 平衡二叉树110 {

    public static void main(String[] args) {
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;

        int leftNum = getHeight(root.left);
        int rightNum = getHeight(root.right);
        if (leftNum == -1 || rightNum == -1) {
            return -1;
        }
        if (Math.abs(leftNum - rightNum) > 1) {
            return -1;
        }

        return 1 + Math.max(leftNum, rightNum);
    }
}
