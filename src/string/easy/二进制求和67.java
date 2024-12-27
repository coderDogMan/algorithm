package string.easy;

public class 二进制求和67 {
    public static void main(String[] args) {
        String s = addBinary("11", "1");
        System.out.println(s);
    }

    public static String addBinary(String a, String b) {
        if (a.length() == 0 || a == null) return b;
        if (b.length() == 0 || b == null) return a;

        int i = a.length() - 1;
        int j = b.length() - 1;
        int temp = 0;
        StringBuffer res = new StringBuffer();
        while (i >=0 && j>=0) {
            int c1 = Integer.parseInt(a.charAt(i) + "");
            int c2 = Integer.parseInt(b.charAt(j) + "");
            res.append((c1 + c2 + temp) % 2);
            temp = (c1 + c2 + temp) / 2;
            --i;
            --j;
        }

        if (j < 0) {
            while (i >= 0) {
                int c1 = Integer.parseInt(a.charAt(i) + "");
                res.append((c1  + temp) % 2);
                temp = (c1  + temp) / 2;
                --i;
            }
        }
        if (i < 0) {
            while (j >= 0) {
                int c2 = Integer.parseInt(b.charAt(j) + "");
                res.append((c2  + temp) % 2);
                temp = (c2  + temp) / 2;
                --j;
            }
        }
        if (temp != 0) res.append(temp);
        return res.reverse().toString();
    }


}
