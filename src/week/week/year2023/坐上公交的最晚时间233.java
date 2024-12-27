package week.week.year2023;

import java.util.Arrays;

public class 坐上公交的最晚时间233 {

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int j = 0;
        int c = capacity;
        for (int i = 0; i < buses.length; i++) {
            c = capacity;
            while (c > 0 && j < passengers.length && passengers[j] <= buses[i]) {
                j++;
                c--;
            }
        }
        j--;
        int ans = c > 0 ? buses[buses.length - 1] : passengers[j];
        while (j >= 0 && passengers[j--] == ans) ans--;
        return ans;
    }

}
class Test97 {
    public static void main(String[] args) {
        坐上公交的最晚时间233 test = new 坐上公交的最晚时间233();
        test.latestTimeCatchTheBus(new int[]{20,30,10}, new int[]{19,13,26,4,25,11,21}, 2);
//        test.latestTimeCatchTheBus(new int[]{10,20}, new int[]{2,17,18,19}, 2);
    }
}
