package week.weektwo98;

public class 替换一个数字后的最大差值6359 {
    public int minMaxDifference(int num) {
        String s = num + "";
        int res = 0;
        for (char i = '0'; i <= '9'; i++) {
            for (char j = '0'; j <= '9'; j++) {
                if (s.contains(i + "") && s.contains(j + "")) {
                    String max = s.replace(i, '9');
                    String min = s.replace(j, '0');
                    res = Math.max(res, Integer.parseInt(max) - Integer.parseInt(min));
                }
            }
        }
        return res;
    }
}
