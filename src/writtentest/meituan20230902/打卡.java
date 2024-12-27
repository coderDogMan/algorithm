package writtentest.meituan20230902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 打卡 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] start = new int[n];
        String[] s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            String[] time = s[i].split(":");
            start[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        int m = Integer.parseInt(in.readLine());
        s = in.readLine().split(" ");
        int[] end = new int[m];
        for (int i = 0; i < n; i++) {
            String[] time = s[i].split(":");
            end[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }
        int time1 = 12 * 60;
        int time2 = 14 * 60;

        int time3 = 18 * 60;
        int time4 = 19 * 60 + 30;
        int[] time = new int[24 * 60 + 1];
        // 不包含头 但包含尾 （】
        for (int i = 0; i < n; i++) {
            int st = start[i] + 1;
            int et = end[i];
            for (; st <= et; st++)
                time[st] = 1;
        }

        int l = start[0] + 1;
        while (l < n) {
            while (l < n && time[l] != 0) {
                l++;
            }
            for (int i = l + 1; i <= 24 * 60; i++) {
                if (time[i] != 0) {
                    if (i - l <= 15) {
                        for (int j = l; j < i; j++) {
                            time[j] = 1;
                        }
                    }
                }
                l = i;
                break;
            }
        }
        for (int i = time1 + 1; i <= time2; i++) {
            time[i] = 0;
        }
        for (int i = time3 + 1; i <= time4; i++) {
            time[i] = 0;
        }
        System.out.println(Arrays.stream(time).sum());


    }
}
