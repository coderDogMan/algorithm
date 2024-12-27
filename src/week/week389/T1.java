package week.week389;

public class T1 {
    public boolean isSubstringPresent(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        String revers = stringBuilder.reverse().toString();
        for (int i = 2; i <= s.length(); i++) {
            if (s.contains(revers.substring(i - 2, i))) return true;
        }
        return false;

    }
}
