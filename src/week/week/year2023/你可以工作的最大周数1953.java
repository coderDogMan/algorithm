package week.week.year2023;

public class 你可以工作的最大周数1953 {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        long max = 0;
        for (int milestone : milestones) {
            sum += milestone;
            max = Math.max(max, milestone);
        }
        long other = sum - max;
        if (other >= max + 1) {
            return sum;
        } else {
            return Math.min(sum, 2 * other + 1);
        }
    }
}
