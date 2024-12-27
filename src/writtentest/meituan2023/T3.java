package writtentest.meituan2023;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        int[] op = new int[m];
        int[] X = new int[m];
        int[] Y = new int[m];
        for (int i = 0; i <m; i++)
            op[i] = in.nextInt();
        for (int i = 0; i <m; i++)
            X[i] = in.nextInt();
        for (int i = 0; i <m; i++)
            Y[i] = in.nextInt();
        SegmentTree segmentTree = new SegmentTree();
        segmentTree.n = n;
        segmentTree.tree = new int[4 * n];
        segmentTree.buildTree(nums, 0, 0, n - 1);

        for (int i = 0; i <m; i++) {
            if (op[i] == 1) {
                int l = X[i] - 1;
                int r = Y[i] - 1;
                System.out.print(segmentTree.queryTree(nums, 0, 0, n - 1, l, r) + " ");
            } else {
                int idx = X[i] - 1;
                int val = Y[i];
                segmentTree.updateTree(nums, 0, 0, n - 1, idx, val);
            }
        }


    }
}
class SegmentTree {
    //n 数组大小 堆的值是数组的4倍
    int n = 13;
    int[] tree = new int[n];

    public void buildTree(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        buildTree(nums, leftNode, start, mid);
        buildTree(nums, rightNode, mid + 1, end);
        tree[node] = tree[leftNode] + tree[rightNode];
    }

    public void updateTree(int[] nums, int node, int start, int end, int index, int val) {
        if (start == end) {
            tree[node] = val;
            nums[index] = val;
            return;
        }
        int mid = (start + end) / 2;
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        if (index >= start && index <= mid) {
            updateTree(nums, leftNode, start, mid, index, val);
        } else {
            updateTree(nums, rightNode, mid + 1, end, index, val);
        }
        tree[node] = tree[leftNode] + tree[rightNode];
    }

    public int queryTree(int[] nums, int node, int start, int end, int L, int R) {
        if (R < start || L > end) {
            return 0;
        } else if (L <= start && R >= end) {
            return tree[node];
        } else if (start == end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        int leftSum = queryTree(nums, leftNode, start, mid, L, R);
        int rightSum = queryTree(nums, rightNode, mid + 1, end, L, R);
        return leftSum + rightSum ;
    }
}

