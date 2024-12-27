package other.mid;

import java.util.Scanner;

public class Max {
    private static String L;
    private static String R;
    private static int left;
    private static int right;
    private static int max;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            L = null;
            R = null;
            StringBuilder sb = new StringBuilder(in.next());
            TreeNode2 tree = buildTree(sb);
            left = getLen(tree.left);
            right = getLen(tree.right);
            TreeNode2 fa = dfs(tree);
            getLeftChar(fa.left, 1);
            max = 0;
            getRightChar(fa.right, 1);
            if (L == null && R == null) {
                L = "";
                R = "";
            } else if (L != null && R == null) {
                R = fa.val + "";
            } else if (L == null && R != null) {
                L =  fa.val + "";
            }
            if (n == 0) {
                System.out.print(left + right + ":" + L + " " + R);
            } else {
                System.out.println(left + right + ":" + L + " " + R);
            }
        }
    }
    private static void getRightChar(TreeNode2 node, int deep) {
        if (node == null) return;
        if (deep > max) {
            R = node.val + "";
        }
        getRightChar(node.left, deep + 1);
        getRightChar(node.right, deep + 1);
    }
    private static void getLeftChar(TreeNode2 node, int deep) {
        if (node == null) return;
        if (deep > max) {
            L = node.val + "";
        }
        getLeftChar(node.left, deep + 1);
        getLeftChar(node.right, deep + 1);

    }
    private static TreeNode2 dfs(TreeNode2 tree) {
        if (tree == null) return null;
        TreeNode2 lNode = dfs(tree.left);
        if (lNode != null) return lNode;
        TreeNode2 rNode = dfs(tree.right);
        if (rNode != null) return rNode;
        int l = getLen(tree.left);
        int r = getLen(tree.right);
        if (l + r == left + right) {
            return tree;
        }
        return null;
    }
    private static int getLen(TreeNode2 tree) {
        if (tree == null) return 0;
        int left = getLen(tree.left);
        int right = getLen(tree.right);

        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }
        return left + right;
    }
    private static TreeNode2 buildTree(StringBuilder sb) {
        if (sb.charAt(0) == '#') {
            sb.delete(0, 1);
            return null;
        }
        TreeNode2 root = new TreeNode2(sb.charAt(0));
        sb.delete(0, 1);
        root.left = buildTree(sb);
        root.right = buildTree(sb);
        return root;
    }
}

class TreeNode2 {
    char val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2() {}
    TreeNode2(char val) { this.val = val; }
    TreeNode2(char val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//4
//A##
//ABC##EF#G###D##
//ABEH###F#K###
//AB###
