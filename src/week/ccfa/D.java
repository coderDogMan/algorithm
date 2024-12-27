package week.ccfa;

import java.util.Scanner;

/**
 * @Author: min
 * @Date:
 */
class Tree {
    int val;
    Tree l;
    Tree r;

    public Tree(int val) {
        this.val = val;
    }
    public void add(Tree node, Tree cur) {
        if (node.val < cur.val) {
            if (cur.l != null) {
                add(node, cur.l);
            } else {
                cur.l = node;
            }
        } else {
            if (cur.r != null) {
                add(node, cur.r);
            } else {
                cur.r = node;
            }
        }
    }

    public int find(int x, Tree cur) {
        if (cur == null) return 1;
        if (cur.val > x) {
            return find(x, cur.l) + 1;
        } else {
            return find(x, cur.r) + 1;
        }
    }
}

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Tree root = new Tree(in.nextInt());
        for (int i = 1; i < n; i++) root.add(new Tree(in.nextInt()), root);
        int h = getH(root);
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int curH = root.find(x, root);
//            if (curH > h) System.out.println(curH);
//            else System.out.println(h);
            System.out.println(curH);
        }
    }

    private static int getH(Tree root) {
        if (root == null) return 0;
        return Math.max(getH(root.l), getH(root.r)) + 1;
    }
}
