//package writtentest.xhs2023;
//
//import java.util.*;
//
//public class 动物之森 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while (t-- > 0) {
//            int n = in.nextInt();
//            LinkedList<Integer>[] bag = new LinkedList[n];
//            Arrays.setAll(bag, e -> new LinkedList<>());
//            HashSet<Integer> setSum = new HashSet<>();
//            LinkedList<Integer> list = new LinkedList<>();
//            boolean flag = true;
//            if (n == 1) {
//                int size = in.nextInt();
//                HashSet<Integer> set = new HashSet<>();
//                for (int j = 0; j < size; j++) {
//                    int num = in.nextInt();
//                    if (set.contains(num)) {
//                        flag = false;
//                    }
//                    set.add(num);
//                    bag[0].add(num);
//                }
//                if (flag) {
//                    System.out.print("Yes ");
//                    Collections.sort(bag[0]);
//                    for (Integer num : bag[0]) {
//                        System.out.print(num + " ");
//                    }
//                    System.out.println();
//                } else {
//                    System.out.println("NO");
//                }
//
//
//            } else {
//                for (int i = 0; i < n; i++) {
//                    int size = in.nextInt();
//                    HashSet<Integer> set = new HashSet<>();
//                    for (int j = 0; j < size; j++) {
//                        int num = in.nextInt();
//                        if (set.contains(num)) {
//                            flag = false;
//                        }
//                        set.add(num);
//                        bag[i].add(num);
//                    }
//                    if (i > 0 && bag[i].size() != bag[i - 1].size()) flag = false;
//                    for (Integer key : set) {
//                        if (setSum.contains(key)) list.add(key);
//                        else setSum.add(key);
//                    }
//
//                }
//                if (!flag) {
//                    System.out.println("NO");
//                } else {
//                    //在全部bag都要出
//                    if (list.size() == 0) {
//                        System.out.println("Yes");
//                    } else {
//                        out(list, bag, n);
//                    }
//                }
//            }
//
//        }
//
//
//    }
//
//    private static void out(LinkedList<Integer> list, LinkedList<Integer>[] bag, int n) {
//        for (Integer key : list) {
//            for (int i = 0; i < n; i++) {
//                if (!bag[i].contains(key)) {
//                    System.out.println("NO");
//                    return;
//                }
//            }
//        }
//        Collections.sort(list);
//        System.out.print("Yes ");
//        for (Integer num : list) {
//            System.out.println(num + " ");
//        }
//        System.out.println();
//    }
//}
