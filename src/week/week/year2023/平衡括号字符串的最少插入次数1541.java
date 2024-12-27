package week.week.year2023;

public class 平衡括号字符串的最少插入次数1541 {
    public int minInsertions(String s) {

        int left = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                if (i < s.length() - 1 && s.charAt(i + 1) == ')') i++;
                else ans++;

                if (left > 0) left--;
                else ans++;
            }
        }
        return ans + left * 2;
    }
}

class Test20 {
    public static void main(String[] args) {
        平衡括号字符串的最少插入次数1541 test = new 平衡括号字符串的最少插入次数1541();
        System.out.println(test.minInsertions(")()"));
    }
}