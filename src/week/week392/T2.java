package week.week392;

public class T2 {

    public String getSmallestString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - 'a';

            for (int j = 0; j < 26 && j < x; j++) {
                if (x - j <= k || j + 26 - x <= k) {
                    k -= Math.min(x - j, j + 26 - x);
                    sb.append((char) (j + 'a'));
                    break;
                }
            }
            if (sb.length() == i) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
