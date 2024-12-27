package week.week356;

public class Q1 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] >= target) ans++;
        }
        return ans;
    }
}
