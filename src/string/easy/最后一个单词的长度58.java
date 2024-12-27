package string.easy;

public class 最后一个单词的长度58 {

    public static void main(String[] args) {
        int i = lengthOfLastWord("Hello World");
        System.out.println(lengthOfLastWord("a "));
        System.out.println(i);
    }

    public static int lengthOfLastWord(String s) {
        if (s.length() == 1 && s != " ") return 1;
        if (s.length() == 1 && s != "") return 0;

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
                if ( i == 0 || s.charAt(i - 1) == ' ') {
                    return count;
                }
                continue;
            }
        }
        return -1;
    }
}
