package week.week.year2024firstQuarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T315 {
    class Tree {
        int[] tree;
        public Tree(int n) {
            tree = new int[n];
        }
        public void add(int i) {
            while (i < tree.length) {
                tree[i]++;
                i += (i & -i);
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

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> ans = new LinkedList<Integer>();
        Tree t = new Tree(20000 + 1);
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i] + 10000;
            ans.addFirst(t.pre(x - 1));
            t.add(x);
        }
        return ans;
    }
}
