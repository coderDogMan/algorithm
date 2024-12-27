package week.week.year2023;

public class 收集足够苹果的最小花园周长1954 {
    public long minimumPerimeter(long neededApples) {
        return find(neededApples) * 8;
    }

    // 找边长 的 1 / 2
    private long find(long neededApples) {
        long l = 2;
        long r = (long) 1e6;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (2 * mid * (mid + 1) * (2 * mid + 1) >= neededApples) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}


class Test17 {
    public static void main(String[] args) {
        System.out.println(126488 / 5040);
    }
}
