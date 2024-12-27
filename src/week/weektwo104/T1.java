package week.weektwo104;

public class T1 {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String s : details) {
            int age = Integer.parseInt(s.substring(11, 13));
            if (ans > 60) ans++;
        }
        return ans;
    }
}
