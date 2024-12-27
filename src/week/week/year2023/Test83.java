package week.week.year2023;

import java.util.LinkedList;

public class Test83 {
    static int h;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(7), null)), new TreeNode(3, null, new TreeNode(6, new TreeNode(8), new TreeNode(9))));
        //获取高
        getHeight(root, 0);
        //获取步长
        int step = (int) (Math.pow(2, h));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && h > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (int j = 0; j < step; j++) System.out.print(" ");
                if (node.val == -1) {
                    System.out.print(" ");
                } else {
                    System.out.print(node.val);
                }
                for (int j = 0; j < step; j++) System.out.print(" ");
                if (node.left != null) {
                    queue.add(node.left);
                } else {
                    queue.add(new TreeNode(-1));
                }
                if (node.right != null) {
                    queue.add(node.right);
                } else {
                    queue.add(new TreeNode(-1));
                }
            }
            System.out.println();
            step >>= 1;
            h--;
        }

    }

    private static void getHeight(TreeNode root, int curH) {
        if (root == null) {
            h = Math.max(h, curH);
            return;
        }
        getHeight(root.left, curH + 1);
        getHeight(root.right, curH + 1);
    }
}
