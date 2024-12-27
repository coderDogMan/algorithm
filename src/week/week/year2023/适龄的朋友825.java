package week.week.year2023;

import java.util.Arrays;

public class 适龄的朋友825 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        for (int i = 0; i < ages.length; i++) {
            int x = ages[i];
            // 找 <= x   找大于 x / 2 + 7 的  找 x > 100 && y < 100
            int j = find(ages, x) - 1;
            int k = find(ages, (double) x / 2 + 7);
            ans += Math.max(0, j - k);
        }
        return ans;

//        find(ages, 10);

    }

    private int find(int[] ages, double n) {
        int l = 0;
        int r = ages.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ages[mid] > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

class Test36 {
    public static void main(String[] args) {
        适龄的朋友825 test = new 适龄的朋友825();
        test.numFriendRequests(new int[]{108,115,5,24,82});
//        test.numFriendRequests(new int[]{16, 16});
    }
}