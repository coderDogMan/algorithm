package week.week.year2024secondQuarter;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: min
 * @Date:
 */
public class T2866 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        int[] a = maxHeights.stream().mapToInt(i -> i).toArray();
        long[] suf = new long[n + 1];
        LinkedList<Integer> q = new LinkedList<>();
        long sum = 0;
        q.add(n);
        for (int i = n - 1; i >= 0; i--) {
            int x = a[i];
            while (q.size() > 1 && a[i] < a[q.peekLast()]) {
                int j = q.pollLast();
                sum -= (long) a[j] * (q.peekLast() - j);
            }
            sum += (long) x * (q.peekLast() - i);
            suf[i] = sum;
            q.add(i);
        }
        q.clear();
        q.add(-1);
        long pre = 0;
        long ans = sum;
        for (int i = 0; i < n; i++) {
            int x = a[i];
            while (q.size() > 1 && a[i] < a[q.peekLast()]) {
                int j = q.pollLast();
                pre -= (long) a[j] * (j - q.peekLast());
            }
            pre += (long) x * (i - q.peekLast());
            ans = Math.max(ans, pre + suf[i + 1]);
            q.add(i);
        }
        return ans;
    }

    public long maximumSumOfHeights(int[] a) {
        int n = a.length;
//        int[] a = maxHeights.stream().mapToInt(i -> i).toArray();
        long[] suf = new long[n + 1];
        LinkedList<Integer> q = new LinkedList<>();
        long sum = 0;
        q.add(n);
        for (int i = n - 1; i >= 0; i--) {
            int x = a[i];
            while (q.size() > 1 && a[i] < a[q.peekLast()]) {
                int j = q.pollLast();
                sum -= (long) a[j] * (q.peekLast() - j);
            }
            sum += (long) x * (q.peekLast() - i);
            suf[i] = sum;
            q.add(i);
        }
        q.clear();
        q.add(-1);
        long pre = 0;
        long ans = sum;
        for (int i = 0; i < n; i++) {
            int x = a[i];
            while (q.size() > 1 && a[i] < a[q.peekLast()]) {
                int j = q.pollLast();
                pre -= (long) a[j] * (j - q.peekLast());
            }
            pre += (long) x * (i - q.peekLast());
            ans = Math.max(ans, pre + suf[i + 1]);
            q.add(i);
        }
        return ans;
    }

}
class Test2 {
    public static void main(String[] args) {
        T2866 test = new T2866();
        test.maximumSumOfHeights(new int[]{5,3,4,1,1});
    }
}
