package week.week.year2024firstQuarter;

public class 匹配模式数组的子数组数目II3036 {

    int n;
    int m;
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        n = nums.length;
        m = pattern.length;
        int[] next = getNext(pattern);
        int ans = 0;
        int[] s = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                s[i] = 1;
            } else if (nums[i + 1] < nums[i]) {
                s[i] = -1;
            }
        }
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            while (j > 0 && s[i] != pattern[j]) {
                j = next[j - 1];
            }
            if (s[i] == pattern[j]) {
                j++;
            }
            if (j == m) {
                ans++;
                j = next[j - 1];
            }
        }
        return ans;
    }

    private int[] getNext(int[] pattern) {
        int[] next = new int[m];
        int maxLength = 0;
        for (int i = 1; i < m; i++) {
            while (maxLength > 0 && pattern[maxLength] != pattern[i]) {
                maxLength = next[maxLength - 1];
            }
            if (pattern[maxLength] == pattern[i]) {
                maxLength++;
            }
            next[i] = maxLength;
        }
        return next;
    }
}

class Test6 {
    public static void main(String[] args) {
        匹配模式数组的子数组数目II3036 test = new 匹配模式数组的子数组数目II3036();
        test.countMatchingSubarrays(new int[]{739984096,323353500,59717380,323353500,323353500}, new int[]{-1,1,0});
        test.countMatchingSubarrays(new int[]{1,2,3,4,5,6}, new int[]{1,1});
    }

}