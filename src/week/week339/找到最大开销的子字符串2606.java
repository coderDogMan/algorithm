package week.week339;

public class 找到最大开销的子字符串2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] val = new int[26];
        for (int i = 1; i <= 26; i++)
            val[i] = i;
        for (int i = 0; i < vals.length; i++) {
            val[chars.charAt(i) - 'a'] = vals[i];
        }
        int max = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            temp += val[s.charAt(i) - 'a'];
            if (temp > max) max = temp;
            if (temp < 0) temp = 0;
        }
        return max;
    }
}
