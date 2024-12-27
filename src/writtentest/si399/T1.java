package writtentest.si399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class T1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<int[]> list = new LinkedList<>();
        String s = in.readLine();
        while ((s = in.readLine()) != "" && s != null) {
            String[] split = s.split(" ");
            int l = Integer.parseInt(split[0]);
            int r = Integer.parseInt(split[1]);
            list.add(new int[]{l, r});
        }
        Collections.sort(list, (a, b) -> (a[0] - b[0]));
        LinkedList<int[]> ans = new LinkedList<>();
        int l = 0;
        if (list.size() > 0) l = list.getFirst()[0];
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] <= list.get(i - 1)[1]) {
                list.get(i)[1] = Math.max(list.get(i)[1], list.get(i - 1)[0]);
            } else {
                ans.add(new int[]{l, list.get(i - 1)[1]});
                l = list.get(i)[0];
            }
        }
        for (int[] an : ans) {
            System.out.print(an[0] + " " + an[1]);
            System.out.println();
        }
    }
}
