package week.week.year2024firstQuarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T3072 {
    class Tree {
        int[] tree;
        public Tree(int n ) {
            tree = new int[n];
        }
        public void add(int i ) {
            while (i < tree.length) {
                tree[i]++;
                i += i & -i;
            }
        }

        public int pre(int i) {
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i = i & (i - 1);
            }
            return res;
        }
    }

    public int[] resultArray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted); // 只排序不去重
        int n = nums.length;
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(nums[0]);
        b.add(nums[1]);
        Tree t1 = new Tree(n + 1);
        Tree t2 = new Tree(n + 1);
        t1.add(Arrays.binarySearch(sorted, nums[0]) + 1);
        t2.add(Arrays.binarySearch(sorted, nums[1]) + 1);
        for (int i = 2; i < n; i++) {
            int x = nums[i];
            int v = Arrays.binarySearch(sorted, x) + 1;
            int gc1 = a.size() - t1.pre(v);
            int gc2 = b.size() - t2.pre(v);
            if (gc1 > gc2 || (gc1 == gc2 && a.size() <= b.size())) {
                a.add(x);
                t1.add(v);
            } else {
                b.add(x);
                t2.add(v);
            }
        }
        a.addAll(b);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = a.get(i);
        return ans;
    }
}

class Test35 {
    public static void main(String[] args) {
        T3072 t3072 = new T3072();
        t3072.resultArray(new int[]{2,1,3,3});
    }
}
