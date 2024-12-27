package array.easy;


public class 字符串中的第一个唯一字符387{
    public static void main(String[] args) {
        int i = firstUniqChar("loveleetcode");
        System.out.println(i);
    }
    public static int firstUniqChar(String s) {
        StringBuilder builder = new StringBuilder(s);
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int i = builder.indexOf(aChar + "");
            int i1 = builder.lastIndexOf(aChar + "");
            if (i == i1) return i;
        }
        return -1;
    }
}
