package writtentest.huawei2023;

import java.util.LinkedList;
import java.util.Scanner;

public class 删除数字 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        //栈外数字个数
        int[] outMap = new int[10];
        for (int i = 0; i < n; i++) {
            outMap[s.charAt(i) - '0']++;
        }
        //栈内数字个数
        int[] inMap = new int[10];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            if (inMap[num] == 2) {
                outMap[num]--;
                continue;
            }
            //栈为空 并且栈内这个数小于2之间入栈
            if (stack.isEmpty()) {
                stack.add(num);
                inMap[num]++;
                outMap[num]--;
            } else if (inMap[num] < 2 && num <= stack.getLast()) {
                stack.add(num);
                inMap[num]++;
                outMap[num]--;
            } else if (num > stack.getLast()){
                while (!stack.isEmpty() && num > stack.getLast() && outMap[stack.getLast()] + inMap[stack.getLast()] > 2) {
                    Integer last = stack.pollLast();
                    inMap[last]--;
                }
                stack.add(num);
                inMap[num]++;
                outMap[num]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb.toString());
    }
}
//
//class Main{
//    public static void main(String[] args){
//        // 最大字典序问题，重复数字保留至多两位，单调递减栈 + 哈希表
//        // 题目要求
//        // 1、给定的s串中每个数字至多出现两次(只能删除重复两次以上的部分)
//        // 2、数字类型不能缺失(不同的数字数量必须保持一致)
//        // 3、各个数字前后次序关系不能乱，也就是必须原地删除
//        // 4、所得最终结果表示为数字时最大，可以理解为字典序最大，也就是让越大的数字尽量保留在靠前的位置。
//        // 并且数字位数要在合理范围内最大(有效位数越多数字越大)，那么也就是任何重复数字都保留最大可存在次数2，不重复数字保留1个。
//        Scanner input = new Scanner(System.in);
//        String s = input.next();
//        int n = s.length();
//        // hash维护剩余未遍历字符串中的各个数字数量。
//        int[] hash = new int[10];
//        // intStack维护栈中已有各个数字数量
//        int[] inStack = new int[10];
//        // 哈希表统计所有数字出现次数
//        for(int i = 0; i < n; ++i) ++hash[s.charAt(i)-'0'];
//        Deque<Character> stack = new ArrayDeque<>();
//        // 维护单调递减栈，栈中任何时刻所有数字重复次数不超过2，当前遍历的数字c符合栈中的递减排序时直接入栈(c小于等于栈顶数字)
//        // 当c大于栈顶数字时，说明将c放在靠前的位置字典序更大，那么需要考虑是否将栈顶弹出，
//        // 而弹出栈顶top需要保证后续栈中仍然能凑齐最终结果中应有的top数量，也就是：
//        // 1、如果s中top数量>=2，那么结果中必须有两个top；
//        // 2、如果s中只有一个top，那结果中也必须有一个top。
//        // 而所有已经弹出的数字都视为舍弃不用，那么栈顶数字能弹出的条件就是栈中已存在的top数量+后方未遍历部分剩余的top数量>2。如果只有一个必定不可弹出否则会缺失数字类型。
//        // 即 inStack[top] + hash[top] > 2
//        for(int i = 0; i < n; ++i){
//            char c = s.charAt(i);
//            // 每遍历一个数字，其后方剩余数量hash-1。
//            --hash[c - '0'];
//            // 若前方栈中已存在两个c，则当前遇到的第三个c直接跳过，因为栈中前方已有的两个c一定在更靠前的位置，对较大字典序的贡献更大(只有数量仅为1或2的数字可能打破栈的递减次序，因为即便遇到更大的数字也无法弹出，否则会造成最终结果数字数量的缺失)。
//            if(inStack[c - '0'] == 2) continue;
//            while(!stack.isEmpty() && stack.peek() < c && hash[stack.peek()-'0']+inStack[stack.peek()-'0'] > 2){
//                --inStack[stack.pop() - '0'];
//            }
//            // 确定c符合栈的递减次序后将其入栈。
//            stack.push(c);
//            ++inStack[c-'0'];
//        }
//        // 全部遍历完s串后，栈中存储的就是在符合不缺失数字类型和数量完整性情况下的最大字典序排列，从栈底依次记录结果即可。
//        String res = "";
//        while(!stack.isEmpty()){
//            res += stack.pollLast();
//        }
//        System.out.println(res);
//    }
//}
