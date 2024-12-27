package tree.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> item = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n =  queue.peek();
                queue.poll();
                item.add(n.val);
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
            list.add(item);
        }
        return list;
    }
}


