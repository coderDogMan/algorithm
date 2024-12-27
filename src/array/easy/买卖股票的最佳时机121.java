package array.easy;

import java.util.HashMap;

public class 买卖股票的最佳时机121 {

    public static void main(String[] args) {
        int i = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(i);

    }

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else if (prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }

    //自己写超时
//    public static int maxProfit(int[] prices) {
//        int max = 0;
//        int temp = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                temp = prices[j] - prices[i];
//                max = max > temp ? max : temp;
//            }
//        }
//        return max;
//    }

}
