package array.mid;

import java.util.ArrayList;

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val,Node2 _left,Node2 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class 剑指Offer36二叉搜索树与双向链表 {
    ArrayList<Integer> list = new ArrayList<>();
    public Node2 treeToDoublyList(Node2 root) {
        traversal(root);
        if (list.size() == 0) return null;
        Node2 head = new Node2(list.get(0));
        head.left = head;
        head.right = head;
        if (list.size() == 1) return head;
        Node2 cur = head;
        Node2 node = new Node2(-1);
        for (int i = 1; i < list.size(); i++) {
            node = new Node2(list.get(i));
            cur.right = node;
            node.left = cur;
            cur = cur.right;
        }
        head.left = node;
        node.right = head;
        return head;
    }

    public void traversal(Node2 root) {
        if (root == null) return;
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}

class Test2 {
    public static void main(String[] args) {
        剑指Offer36二叉搜索树与双向链表 test = new 剑指Offer36二叉搜索树与双向链表();
        Node2 node2 = test.treeToDoublyList(new Node2(1));
        System.out.println(node2);
    }
}