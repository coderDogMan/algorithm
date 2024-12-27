//package other.mid;
//
//import java.util.LinkedList;
//
//public class 剑指OfferII037小行星碰撞 {
//    public int[] asteroidCollision(int[] asteroids) {
//        LinkedList<Integer> stack = new LinkedList<Integer>();
//        int n = asteroids.length;
//        for (int i = 0; i < n; i++) {
//            if (!stack.isEmpty() && stack.getLast() > 0 && asteroids[i] < 0) {
//                if (Math.abs(stack.getLast()) < Math.abs(asteroids[i])) {
//                    while (!stack.isEmpty() && Math.abs(stack.getLast()) < Math.abs(asteroids[i]) && stack.getLast() > 0) {
//                        stack.pollLast();
//                    }
//                    if (Math.abs(stack.getLast()) == Math.abs(asteroids[i])) {
//                        continue;
//                    } else {
//                        stack.addLast(asteroids[i]);
//                    }
//                } else if (!stack.isEmpty() && Math.abs(stack.getLast()) == Math.abs(asteroids[i])) {
//                    stack.pollLast();
//                } else if (stack.isEmpty()) {
//                    stack.add(asteroids[i]);
//                }
//            } else {
//                stack.add(asteroids[i]);
//            }
//        }
//        int[] ans = new int[stack.size()];
//        int index = 0;
//        while (!stack.isEmpty()) ans[index++] = stack.poll();
//        return ans;
//    }
//}
//
//class Test20 {
//    public static void main(String[] args) {
//        剑指OfferII037小行星碰撞 test = new 剑指OfferII037小行星碰撞();
//        test.asteroidCollision(new int[]{10, 2,-5});
//        test.asteroidCollision(new int[]{8, -8});
//        test.asteroidCollision(new int[]{5,10,-5});
//    }
//}