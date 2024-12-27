package writtentest.xc2023;

public class TX2023T4 {
    public int minOperations (String str) {
        int min1 = 0;
        int min2 = 0;
        int n = str.length();
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1') {
                temp++;
            } else if (temp != 0){
                min1 += (temp + 1) / 2;
                temp = 0;
            }
            if (i == n - 1 && temp != 0) {
                min1 += temp / 2 + 1;
            }
        }
        temp = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0') {
                temp++;
            } else if (temp != 0) {
                min2 += (temp + 1) / 2;
                temp = 0;
            }
            if (i == n - 1 && temp != 0) {
                min2 += (temp + 1) / 2;
            }
        }

        return min1 > min2 ? min2 : min1;
    }
}

class Test2 {
    public static void main(String[] args) {
        TX2023T4 test = new TX2023T4();
        test.minOperations("1100");
        test.minOperations("01001");
    }
}