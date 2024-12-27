package writtentest.threeSixZero;


import java.util.*;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 数字   第几个-下标
        HashMap<Long, HashMap<Integer, Long>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long x = in.nextLong();
            if (map.containsKey(x)) {
                HashMap<Integer, Long> m = map.get(x);
                m.put(m.size() + 1, i + 1L);
            } else {
                HashMap<Integer, Long> m = new HashMap<>();
                m.put(1, i + 1L);
                map.put(x, m);
            }
        }

        ArrayList<Long> ans = new ArrayList<>(10000);
        System.out.println(map.size());
        for (Long x : map.keySet()) {
            HashMap<Integer, Long> m = map.get(x);
            int cnt = m.size();
            int idx = cnt / 2 + cnt % 2;
            ans.add(m.get(cnt - idx + 1));
        }
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            if (i == ans.size() - 1) {
                System.out.println(ans.get(i));
            } else {
                System.out.print(ans.get(i) + " ");
            }
        }
    }

}
