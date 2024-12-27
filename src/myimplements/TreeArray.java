package myimplements;

import java.util.HashMap;

public class TreeArray {
    int[] arr;
    int n;

    public long count(int p) {
        long ans = 0;
        while (p != 0) {
            ans += arr[p];
            p -= lowBit(p);
        }
        return ans;
    }

    public void add(int p, int x) {
        while (p < n) {
            arr[p] += x;
            p += lowBit(p);
        }
    }

    public int lowBit(int x) {
        return x & (-x);
    }
}

//class Test {
//    public static void main(String[] args) {
//        TreeArray treeArray = new TreeArray();
//    }
//}
