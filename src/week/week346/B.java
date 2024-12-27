package week.week346;

public class B {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        //奇
        if ((s.length() & 1) == 1) {
            int idx = s.length() / 2;
            int l = idx - 1;
            int r = idx + 1;
            while (l >= 0 && r < s.length()) {
                char lc = s.charAt(l);
                char rc = s.charAt(r);
                if (lc != rc) {
                    if (lc < rc) {
                        sb.replace(r, r + 1, String.valueOf(lc));
                    } else {
                        sb.replace(l, l + 1, String.valueOf(rc));
                    }
                }
                l--;
                r++;
            }
        } else {
            int l = s.length() / 2 - 1;
            int r = l + 1;
            while (l >= 0 && r < s.length()) {
                char lc = s.charAt(l);
                char rc = s.charAt(r);
                if (lc != rc) {
                    if (lc < rc) {
                        sb.replace(r, r + 1, String.valueOf(lc));
                    } else {
                        sb.replace(l, l + 1, String.valueOf(rc));
                    }
                }
                l--;
                r++;
            }
        }
        return sb.toString();

    }
}
