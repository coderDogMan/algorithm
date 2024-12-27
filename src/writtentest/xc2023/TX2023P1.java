package writtentest.xc2023;

public class TX2023P1 {
    int n = 26;
    public int minOperations (String str) {
        int[] dit = new int[26];
        int ans = 0;
        for (char c : str.toCharArray()) {
            if (dit[c - 'a'] == 0) {
                n--;
            }
            dit[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (dit[i] == 1 || dit[i] == 0) {
                continue;
            } else if (dit[i] % 2 == 1){
                ans += getN(dit[i] - 1);
            } else {
                ans += getN(dit[i]);
            }
        }
        return ans > n ? ans - n : ans;
    }
    public int getN (int n) {
        int ans = 0;
        while (n > 0) {
            n >>= 1;
            ans += n;
        }

        return ans;
    }
}

class Test {
    public static void main(String[] args) {
        TX2023P1 test = new TX2023P1();
        test.minOperations("dddndi");
        System.out.println(test.minOperations("abab"));
    }
}