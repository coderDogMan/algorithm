package sort.esay;

public class 找不同389 {
    public static void main(String[] args) {
        char theDifference = findTheDifference("abcd", "abcde");
        System.out.println(theDifference);

    }

    public static char findTheDifference(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        char res = 0;
        for (char aChar : chars)
            res ^= aChar;
        for (char aChar : chart)
            res ^= aChar;

        return res;
    }

}
