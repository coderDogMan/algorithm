package week.week356;

public class Q3 {
    public String minimumString(String a, String b, String c) {
        String s1 = join(join(a, b), c);
        String s2 = join(join(a, c), b);
        String s3 = join(join(b, a), c);
        String s4 = join(join(b, c), a);
        String s5 = join(join(c, b), a);
        String s6 = join(join(c, a), b);

        String[] list = {s1, s2, s3, s4, s5, s6};
        String ans = list[0];
        for (String s : list) {
            if (s.length() < ans.length()) {
                ans = s;
            } else if (s.length() == ans.length() && s.compareTo(ans) < 0) {
                ans = s;
            }
        }
        return ans;
    }

    private String join(String a, String b) {
        if (a.contains(b)) return a;
        int min = Math.min(a.length(), b.length());
        while (min-- > 0) {
            if (check(a, b, min)) {
                break;
            }
        }
        return a + b.substring(min);
    }

    private boolean check(String a, String b, int min) {
        int i = a.length() - min, j = 0;
        while (min-- > 0) {
            if (a.charAt(i++) != b.charAt(j++))
                return false;
        }
        return true;
    }


}

class Test3 {
    public static void main(String[] args) {
        Q3 test = new Q3();
        test.minimumString("abc", "bca", "aaa");
    }
}