package week.week.year2023;

import java.util.Arrays;

public class 形成三的最大倍数1363 {

    public String largestMultipleOfThree(int[] digits) {
        int n = digits.length;
        Arrays.sort(digits);
        int sum = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            int x = digits[i];
            if (x % 3 == 1) cnt1++;
            if (x % 3 == 2) cnt2++;
            sum += x;
        }
        if (sum % 3 == 1) {
            if (cnt1 > 0) cnt1--;
            else cnt2 -= 2;
        }
        if (sum % 3 == 2) {
            if (cnt2 > 0) cnt2--;
            else cnt1 -= 2;
        }
        if (cnt1 < 0 || cnt1 < 0) return "";
        StringBuilder sb = new StringBuilder();
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int x = digits[i];
            if (x % 3 == 1 && cnt1 > 0) {
                cnt1--;
                sum += x;
                sb.append(x);
            } else if (x % 3 == 2 && cnt2 > 0) {
                cnt2--;
                sum += x;
                sb.append(x);
            } else if (x % 3 == 0){
                sum += x;
                sb.append(x);
            }
        }
        if (sb.length() > 0 && sum != 0) {
            return sb.toString();
        } else if (sb.length() > 0 && sum == 0) {
            return "0";
        } else {
            return "";
        }
    }

}

class Test75 {
    public static void main(String[] args) {
        形成三的最大倍数1363 test = new 形成三的最大倍数1363();
        test.largestMultipleOfThree(new int[]{8,6,7,1,0});
    }
}