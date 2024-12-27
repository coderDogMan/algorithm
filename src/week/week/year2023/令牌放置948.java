package week.week.year2023;

import java.util.Arrays;

public class 令牌放置948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        int r = tokens.length - 1;
        int l = 0;
        Arrays.sort(tokens);
        int ans = 0;
        while (l < r) {
            if (tokens[l] <= power) {
                ans++;
                power -= tokens[l];
                l++;
            } else if (ans > 0 && l != r){
                ans--;
                power += tokens[r];
                r--;
            } else {
                break;
            }
        }
        return ans;
    }
}

class Test25 {
    public static void main(String[] args) {
        令牌放置948 test = new 令牌放置948();
        test.bagOfTokensScore(new int[]{100,200,300,400}, 200);
//        test.bagOfTokensScore(new int[]{100,200}, 150);
    }

}
