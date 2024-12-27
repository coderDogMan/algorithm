package week.week.year2024firstQuarter;

public class 将单词恢复初始状态所需的最短时间I3029 {

    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int start = k;
        int ans = 1;
        while (start < n && !word.substring(start).equals(word.substring(0, n -start))) {
            start += k;
            ans++;
        }
        return ans;


    }

}
