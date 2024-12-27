package tree.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 剑指Offer32III从上到下打印二叉树III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        boolean flag = false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size =  queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                } else {
                    if (node.right != null) queue.addLast(node.right);
                    if (node.left != null) queue.addLast(node.left);
                }
                list.add(node.val);
            }
            flag = !flag;
            ans.add(list);
        }
        return ans;
    }
}
class Test {
    public static void main(String[] args) {
        剑指Offer32III从上到下打印二叉树III test = new 剑指Offer32III从上到下打印二叉树III();
        test.levelOrder(new TreeNode(1
                , new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        test.levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
    }
}