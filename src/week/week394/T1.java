package week.week394;

import writtentest.huawei2023.分配资源ID;

public class T1 {

    public int numberOfSpecialChars(String word) {
        int[] cnt = new int[200];
        for (char c : word.toCharArray()) {
            cnt[c]++;
        }
        int ans = 0;
        for (int i = 'a'; i <= 'z'; i++) {if (cnt[i] != 0 && cnt[i - 32] != 0) ans++;}
        return ans;
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println( (int) 'A');
    }
}
