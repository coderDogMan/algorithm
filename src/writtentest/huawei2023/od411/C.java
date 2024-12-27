package writtentest.huawei2023.od411;

import java.util.*;

public class C {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] sum = new int[n + 1];
        HashMap<Integer, LinkedList<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            sum[i + 1] = nums[i] + sum[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int num = sum[j + 1] - sum[i];
                int[] val = {i + 1, j + 1};
                if (map.get(num) == null) {
                    LinkedList<int[]> list = new LinkedList<>();
                    list.add(val);
                    map.put(num, list);
                } else {
                    map.get(num).add(val);
                }
            }
        }
        int ans = 0;
        for (Integer key : map.keySet()) {
            int dif = 0;
            LinkedList<int[]> list = map.get(key);
            Collections.sort(list, (a, b) -> (a[0] - b[0]));
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i)[0] <= list.get(i - 1)[1]) {
                    dif++;
                    list.get(i)[1] = Math.min(list.get(i - 1)[1], list.get(i)[1]);
                }
            }
            ans = Math.max(ans, list.size() - dif);
        }
        System.out.println(ans);
    }
}
