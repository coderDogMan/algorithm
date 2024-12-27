package week.week.year2024firstQuarter;

public class T2426 {


    class Tree {
        int[] tree;
        public Tree(int n) {
            tree = new int[n];
        }
        public void add(int i) {
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
    // nums1[i] - nums1[j] - nums2[i] + nums2[j] <= diff
    // (nums1[i] - nums2[i]) - (nums1[j] - nums2[j]) <= diff
    // a - b <= diff
    // a <= b + diff
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int add = (int) 1e4 * 2 + 1;
        int n = nums1.length;
        int N = (int) 1e5;
        Tree t = new Tree(N);
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int a = nums1[i] - nums2[i];
            int b = nums1[i] - nums2[i];
            ans += (t.pre(N - 1) - t.pre(a + add));
            t.add(b + diff + add);
        }
        return ans;
    }
}

class Test36 {
    public static void main(String[] args) {
        T2426 test = new T2426();
//        test.numberOfPairs(new int[]{})
    }
}


