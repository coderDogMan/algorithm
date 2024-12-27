package week.week.year2023;

public class 最短且字典序最小的美丽子字符串100084 {
    public String shortestBeautifulSubstring(String s, int k) {

        int num = 0;
        int j = 0;
        int l = -1;
        int r = s.length();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') num++;
            while (j < s.length() && (num > k || s.charAt(j) == '0')) {
                if (s.charAt(j) == '1') num--;
                j++;
            }
            if (num == k && i - j < r - l) {
                r = i;
                l = j;
                ans = s.substring(l, r + 1);
            } else if (num == k && i - j == r - l) {
                String substring = s.substring(j, i + 1);
                int compare = ans.compareTo(substring);
                if (compare == 1) {
                    ans = substring;
                }
            }
        }
        return ans;

    }
}

class Test85 {
    public static void main(String[] args) {
        最短且字典序最小的美丽子字符串100084 test = new 最短且字典序最小的美丽子字符串100084();
        test.shortestBeautifulSubstring("001110101101101111", 10);
    }
}