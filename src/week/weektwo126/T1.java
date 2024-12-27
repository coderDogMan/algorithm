package week.weektwo126;

public class T1 {
    public int sumOfEncryptedInt(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int max = '0';
            String s = String.valueOf(num);
            for (char c : s.toCharArray()) {
                max = Math.max(max, c);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(max);
            }
            res += Integer.parseInt(sb.toString());
        }
        return res;
    }
}
