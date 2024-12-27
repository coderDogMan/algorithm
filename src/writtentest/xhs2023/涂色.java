package writtentest.xhs2023;

import java.util.Arrays;
import java.util.Scanner;

public class 涂色 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(in.nextLine());
        int[] L = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] R = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String s = in.nextLine();
        int[] G = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < m; i++) {
            int g = G[i];
            int l = L[i] - 1;
            int r = R[i] - 1;
            char c = s.charAt(i);
            if (c == '|') {
                op1(nums, l, r, g);
            } else if (c == '&') {
                op2(nums, l, r, g);
            } else {
                op3(nums, l, r, g);
            }
        }
        for (int i = 0; i < n; i++)
            System.out.print(nums[i] + " ");
    }

    public static void op1 (int[] nums, int l, int r, int g) {
        for (int j = l; j <= r; j++) {
            nums[j] |= g;
        }
    }

    public static void op2 (int[] nums, int l, int r, int g) {
        for (int j = l; j <= r; j++) {
            nums[j] &= g;
        }
    }

    public static void op3 (int[] nums, int l, int r, int g) {
        for (int j = l; j <= r; j++) {
            nums[j] = g;
        }
    }
}


class Main {

    public static void op1_or(int[] nums , int left ,int right,int x){
        for (int i = left-1; i <=right-1; i++) {
            nums[i] |= x;
        }
        return ;
    }

    public static void op2_and(int[] nums , int left ,int right,int x){
        for (int i = left-1; i <=right-1; i++) {
            nums[i] &= x;
        }
        return ;
    }

    public static void op3_set(int[] nums , int left ,int right,int x){
        for (int i = left-1; i <=right-1; i++) {
            nums[i] = x;
        }
        return ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int opNum = Integer.parseInt(sc.nextLine());
        int[] leftPoint = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] rightPoint = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String opStr = sc.nextLine();
        int[] xnums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < opNum; i++) {
            char op = opStr.charAt(i);
            if(op=='='){
                op3_set(nums,leftPoint[i],rightPoint[i],xnums[i]);
            }
            else if(op=='|'){
                op1_or(nums,leftPoint[i],rightPoint[i],xnums[i]);
            }
            else{
                op2_and(nums,leftPoint[i],rightPoint[i],xnums[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if(i==0) System.out.print(nums[i]);
            else{
                System.out.print(" "+nums[i]);
            }
        }
    }


}