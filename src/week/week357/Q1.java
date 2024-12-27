package week.week357;

public class Q1 {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                sb.reverse();
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
