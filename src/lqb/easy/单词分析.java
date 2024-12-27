package lqb.easy;

import java.util.Scanner;

public class 单词分析 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arr[] = new int[26];
        String s = scan.nextLine();
        int max = 0;
        int maxchar = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int index = aChar - 'a';
            arr[index] = arr[index] + 1;
            if (arr[index] >= max) {
                max = arr[index];
                maxchar = index;
            }
        }
        System.out.println((char) (maxchar + 'a'));
        System.out.println(max);
    }


}
