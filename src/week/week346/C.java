package week.week346;

public class C {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
           if (isNum(String.valueOf(i * i), 0, 0, i)) {
               ans += i * i;
           }
        }

        return ans;
    }

    private boolean isNum(String s, int startIdx, int sum, int target) {
        if (startIdx == s.length()) {
            if (sum == target) {
                return true;
            } else {
                return false;
            }
        }

        for (int i = startIdx; i < s.length(); i++) {
            if (isNum(s, i + 1, sum + Integer.parseInt(s.substring(startIdx, i + 1)), target)) return true;
        }
        return false;
    }


}
class Test3 {
    public static void main(String[] args) {
        C c = new C();
        c.punishmentNumber(10);
    }
}
//0001
//0001

//01010001
//    1001

//01100100
//    1010

//010100010000
//    00100100


//  1
//  1

// 1001
// 1001

// 0001
// 1010

//00010010
//00100100