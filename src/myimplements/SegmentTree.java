package myimplements;

public class SegmentTree {
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
class Test2 {
    public static void main(String[] args) {
        SegmentTree st = new SegmentTree();
        int[] nums = new int[]{1,3,5,7,9,11};

        st.buildTree(nums, 0, 0, nums.length - 1);
        st.updateTree(nums,0, 0, nums.length - 1, 4, 6);
        System.out.println(st.queryTree(nums, 0, 0, nums.length - 1, 2, 5));
        System.out.println(st);
    }
}