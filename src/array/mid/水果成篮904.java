//package array.mid;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class 水果成篮904 {
//    public static void main(String[] args) {
//        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
//    }
//
//    public static int totalFruit(int[] fruits) {
//        Set<Integer> lan1 = new HashSet<>();
//        Set<Integer> lan2 = new HashSet<>();
//
//        for (int fruit : fruits) {
//            if (!lan1.contains(fruit)){
//                lan1.add(fruit);
//            } else if ((!lan2.contains(fruit))) {
//                lan2.add(fruit);
//            }
//        }
//        return lan1.size() + lan2.size();
//    }
//}
