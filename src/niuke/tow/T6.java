package niuke.tow;

import java.util.Scanner;

public class T6 {

    static long[] arr;
    static long[] tree;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        arr = new long[n];
        tree = new long[4 * arr.length];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        build(0, 0, arr.length - 1);
        while (q-- > 0) {
            int p = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            if (p == 1) {
                update(0, 0, arr.length - 1, x - 1, arr[x - 1] + y);
            } else {
                System.out.println(query(0, 0, arr.length - 1, x - 1, y - 1));
            }
        }
    }
    /**
     * @param node 当前结点
     * @param l l和r表示当前的范围
     * @param r
     */
    public static void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        int l_child = 2 * node + 1;
        int r_child = 2 * node + 2;
        build(l_child, l, mid);
        build(r_child, mid + 1, r);
        tree[node] = tree[l_child] + tree[r_child];
    }
    /**
     * @param node 	当前结点
     * @param l		当前结点对应的区间为l~r
     * @param r
     * @param idx	需更新点的下标（原数组下标）
     * @param val	更新为什么值
     */
    public static void update(int node, int l, int r, int idx, long val) {
        if (l == r) {	//l=r的时候，表示找到了idx对应的结点
            tree[node] = val;	//更新树的结点
            arr[idx] = val;		//更新原数组的值
            return;
        }
        int mid = (l + r) >> 1;
        int l_child = 2 * node + 1;
        int r_child = 2 * node + 2;
        if (idx <= mid) {
            update(l_child, l, mid, idx, val);
        }else {
            update(r_child, mid + 1, r, idx, val);
        }
        //更新父节点的值
        tree[node] = tree[l_child] + tree[r_child];
    }

    /**
     * @param node	当前结点
     * @param l		当前结点对应的区间为l~r
     * @param r
     * @param start 查询区间的范围为start~end
     * @param end
     * @return
     */
    public static long query(int node, int l, int r, int start, int end) {
        if (start > r || end < l) {	//不在查询的范围
            return 0;
        }
        if (start <= l&& end >= r) {//在查询范围，直接返回
            return tree[node];
        }
        int mid = (l + r) >> 1;
        int l_child = node * 2 + 1;
        int r_child  = node * 2 + 2;
        long l_sum = query(l_child, l, mid, start, end);		//左子树的和
        long r_sum = query(r_child, mid + 1, r, start, end);	//右子树的和
        //返回左子树加右子树的和
        return l_sum + r_sum;
    }
}
