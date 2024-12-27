package niuke.test4;

import java.util.ArrayList;
import java.util.Scanner;

public class T2 {
    static ArrayList<String> ans = new ArrayList<String>();
    static StringBuilder path = new StringBuilder();
    static int[][] arr = new int[][] {{1,2},{1,2},{1,2},{1,2},{1,2},{1,2}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        dfs(arr, 0);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i) + "");
        }
    }

    private static void dfs(int[][] arr, int deep) {
        if (path.length() == 6) {
            ans.add(path.toString());
            return;
        }
        int[] nums = arr[deep];
        for (int i = 0; i < nums.length; i++) {
            path.append(nums[i] + "");
            dfs(arr, deep + 1);
            path.delete(path.length() - 1, path.length());
        }
    }
}
