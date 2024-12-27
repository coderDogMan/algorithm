package tree.easy;

import javafx.scene.layout.Priority;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉搜索树中的众数501 {
    private static int count;
    private static int maxCount;

    private static Queue<Integer> queue = new LinkedList<Integer>();
    private static TreeNode prev;


    public static void main(String[] args) {
        findMode(new TreeNode(1,null,new TreeNode(2)));
    }

    //左中右
    public static int[] findMode(TreeNode root) {
        traversal(root);
        int size = queue.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++){
            res[i] = queue.poll();
        }

        return res;
    }

    public static void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (prev == null) count = 1;
        else if (prev.val == root.val) count++;
        else if (prev.val != root.val)count = 1;
        if (count > maxCount){
            maxCount = count;
            queue.clear();
            queue.add(root.val);
        } else if (count == maxCount) {
            queue.add(root.val);
        }

        prev = root;
        traversal(root.right);
    }
}
