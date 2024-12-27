package array.mid;

import java.util.PriorityQueue;

public class 积压订单中的订单总数1801 {

    public static void main(String[] args) {
        getNumberOfBacklogOrders(new int[][]{{10,5,0}, {15,2,1}, {25,1,1}, {30,4,0}});
    }

    public static int getNumberOfBacklogOrders(int[][] orders) {
        int mod = 1000000000 + 7;
        PriorityQueue<Integer> buyQue = new PriorityQueue<>((i1, i2)->orders[i2][0] - orders[i1][0]);
//        PriorityQueue<Integer> bayQueue = new PriorityQueue<>((e1, e2) -> orders[e2][0] - orders[e1][0]);
        buyQue.add(3);
        buyQue.add(1);
        buyQue.add(2);
        buyQue.add(0);
        PriorityQueue<Integer> sellQueue = new PriorityQueue<>();
//        for (int i = 0; i < orders.length; i++) {
//            if (orders[i][2] == 0) {
//                for (int j = 0; j < orders[i][1]; j++) {
//                    if (!sellQueue.isEmpty() && orders[i][0] > sellQueue.peek()) {
//                        sellQueue.poll();
//                        continue;
//                    }
//                    bayQueue.add(orders[i][0]);
//                }
//            }
//            if (orders[i][2] == 1) {
//                for (int j = 0; j < orders[i][1]; j++) {
//                    if (!bayQueue.isEmpty() && bayQueue.isEmpty() && orders[i][0] <= bayQueue.peek()) {
//                        sellQueue.poll();
//                        continue;
//                    }
//                    sellQueue.add(orders[i][0]);
//                }
//            }
//        }
//
//        return sellQueue.size() % mod + bayQueue.size() % mod;
        return 0;
    }
}
