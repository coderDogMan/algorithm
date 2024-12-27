package myimplements;

public class 手写KMP {
    public static void main(String[] args) {
        String T = "aabaabaaf";
        String P = "aabaad";
        int[] next = 手写获取KMPnext数组.getNext(P);
        int i = 0;
        int j = 0;
        int lent = T.length();
        int lenp = P.length();
        while (i < lent && j < lenp) {
            if (T.charAt(i) == P.charAt(j)) {
                i++;
                j++;
            } else if(j > 0) {
                j = next[j - 1];

            } else if (T.charAt(i) != P.charAt(j) && i == lent - 1) { //目标串找完
                break;
            }
        }
        if (j == lenp) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }
}
