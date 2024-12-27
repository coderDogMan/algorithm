package tree.easy;

import java.util.*;

public class 二叉树的所有路径257 {
    public static void main(String[] args) {
        binaryTreePaths(new TreeNode(1,new TreeNode(2,null, new TreeNode(5)),new TreeNode(3)));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        traversal(root, path, res);
        return res;
    }
    public static void traversal(TreeNode root, List<Integer> path, List<String> res) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < path.size() - 1; i++)
                sb.append(path.get(i)).append("->");
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
            return ;
        }
        if (root.left != null) {
            traversal(root.left, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null){
            traversal(root.right, path, res);
            path.remove(path.size() - 1);
        }
    }
}
