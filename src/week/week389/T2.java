package week.week389;

public class T2 {
    public long countSubstrings(String s, char c) {
        long cnt = 0;
        for (char c1 : s.toCharArray()) {
            if (c1 == c) cnt++;
        }
//        if (cnt == 1) return 1;
//        else if (cnt == 2) return 3;
        return cnt * (cnt + 1) / 2;

    }
}
