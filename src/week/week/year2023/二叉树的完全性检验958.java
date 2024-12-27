package week.week.year2023;

import java.util.LinkedList;

public class 二叉树的完全性检验958 {
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        int size = queue.size();
        int num = queue.size();
        while (!queue.isEmpty()) {
            size = queue.size();
            boolean left = true;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null && !left) {
                    return false;
                } else if (poll.left != null) {
                    queue.add(poll.left);
                } else {
                    left = false;
                }
                if (poll.right != null && !left) {
                    return false;
                } else if (poll.right != null) {
                    queue.add(poll.right);
                } else {
                    left = false;
                }
            }
            if (size != num && !queue.isEmpty()) {
                return false;
            }
            num *= 2;
        }
        return true;
    }
}
class Test7 {
    public static void main(String[] args) {
        二叉树的完全性检验958 test = new 二叉树的完全性检验958();
        test.isCompleteTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, null, new TreeNode(7))));
    }
}

