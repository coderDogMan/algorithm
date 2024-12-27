package string.mid;

public class 括号的分数856 {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()(()))"));
    }

    public static int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        }

        char[] chars = s.toCharArray();
        int flag = 0; int n = chars.length; int len = 0;

        for(int i = 0; i < n; i++) {
            flag += chars[i] == '(' ? 1 : -1;
            if (flag == 0) {
                len = i + 1;
                break;
            }
        }
        if (len == n) {
            return 2 * scoreOfParentheses(s.substring(1, n - 1));
        } else {
            return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len));
        }
    }

}
