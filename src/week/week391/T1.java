package week.week391;

public class T1 {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int ans = 0;
        int temp = x;
        while (x > 0) {
            ans += (x % 10);
            x = x / 10;
        }
        if (temp % ans != 0)
            return -1;
        return ans;
    }
}
