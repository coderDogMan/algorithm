package week.week.year2023;

import java.util.LinkedList;

public class LCR187破冰游戏 {
    public int iceBreakingGame(int num, int target) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            list.add(i);
        }
        int cur = 0;
        while (list.size() > 1) {
            list.remove((cur + target) % list.size());
        }
        return list.getFirst();

    }
}
