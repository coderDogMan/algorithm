package week.week335;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class 二叉树中的第K大层和6308 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>((a, b) -> ( b >= a ? 1 : -1));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode n =  queue.poll();
                sum += n.val;
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
            priorityQueue.add(sum);
        }
        while (k-- > 0) {
            priorityQueue.poll();
        }
        System.out.println();
        return priorityQueue.isEmpty() ? - 1 : priorityQueue.peek();
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
