package writtentest.meituan2023;

import java.util.Scanner;

public class P2 {

    static long[] tree;
    static int n;
    static long[] nums;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        nums = new long[n];
        tree = new long[n * 4];
        int[] op = new int[m];
        int[] X = new int[m];
        int[] Y = new int[m];
        for (int i = 0; i <m; i++)
            op[i] = in.nextInt();
        for (int i = 0; i <m; i++)
            X[i] = in.nextInt();
        for (int i = 0; i <m; i++)
            Y[i] = in.nextInt();
        build(nums, 0, 0, n - 1);
        for (int i = 0; i < m; i++) {
            if (op[i] == 0) {
                int idx = X[i] - 1;
                int val = Y[i];
                update(nums, 0,0,n - 1, idx, val);
            } else {
                int l = X[i] - 1;
                int r = Y[i] - 1;
                System.out.print(sum(nums, 0, 0, n - 1, l, r) + " ");
            }
        }

    }

    public static void build(long[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        int mid = (start + end) / 2;
        build(nums, leftNode, start, mid);
        build(nums, rightNode, mid + 1, end);
        tree[node] = tree[leftNode] + tree[rightNode];
    }

    public static void update(long[] nums, int node, int start, int end, int index, int val) {
        if (start == end) {
            tree[node] = val;
            nums[index] = val;
            return;
        }
        int mid = (start + end) / 2;
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        if (start <= index && index <= mid) {
            update(nums, leftNode, start, mid, index, val);
        } else {
            update(nums, rightNode, mid + 1, end, index, val);
        }
        tree[node] = tree[leftNode] + tree[rightNode];
    }

    public static long sum(long[] nums, int node, int start, int end, int L, int R) {
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
        long leftSum = sum(nums, leftNode, start, mid, L, R);
        long rightSum = sum(nums, rightNode, mid + 1, end, L, R);
        return leftSum + rightSum ;
    }
}
