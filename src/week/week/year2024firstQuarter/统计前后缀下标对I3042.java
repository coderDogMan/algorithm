package week.week.year2024firstQuarter;

public class 统计前后缀下标对I3042 {

    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) ans++;
            }
        }
        return ans;
    }

    private boolean isPrefixAndSuffix(String si, String sj) {
        if (sj.length() < si.length()) return false;
        int n = si.length();
        int m = sj.length();
        return sj.substring(0, n).equals(si) && sj.substring(m - n - 1, m).equals(sj);
    }

}
