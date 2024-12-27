package week.week.year2023;

public class 使字符串平衡的最少删除次数1653 {

    int[] memo;
    char[] s;
    int cntB;
    public int minimumDeletions(String s) {
        int n = s.length();
        memo = new int[n];
        this.s = s.toCharArray();
        return dfs(n - 1);
    }

    private int dfs(int i) {
        if (i < 0) return 0;
        int num = 0;
        if (memo[i] != 0) return memo[i];
        if (s[i] == 'b') {
            num = dfs( i - 1);
            cntB++;
        } else {
            num = Math.min(dfs(i - 1) + 1, cntB);
        }
        memo[i] = num;
        return num;
    }

    public int minimumDeletions2(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int cntA = 0;
        for (char aChar : chars) {
            if (aChar == 'a') cntA++;
        }
        int ans = Integer.MAX_VALUE;
        int curA = 0;
        int curB = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, (cntA - curA) + (i - curA));
            if (chars[i] == 'a') curA++;
        }


        return ans;
    }
}

class Test37 {
    public static void main(String[] args) {
        使字符串平衡的最少删除次数1653 test = new 使字符串平衡的最少删除次数1653();
        test.minimumDeletions("a");
        test.minimumDeletions("aababbab");
    }
}
