package backtacking.mid;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合17 {

    private static List<String> result = new ArrayList<>();
    private static StringBuffer path = new StringBuffer();
    private static String[] cast = {"", "", "abc", "def", "ghi", "jkl","mno", "pqrs", "tuv", "wxyz" };

    public static void main(String[] args) {
        letterCombinations("");
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        backtracking(digits, 0);
        return result;
    }

    public static void backtracking(String digits, int index) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return ;
        }
        String s = cast[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            backtracking(digits, index + 1);
            path.delete(path.length() - 1, path.length());
        }
    }
}
