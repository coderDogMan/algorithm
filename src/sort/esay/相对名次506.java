package sort.esay;

import java.util.Arrays;
import java.util.HashMap;

public class 相对名次506 {
    public static void main(String[] args) {

    }

    public static String[] findRelativeRanks(int[] score) {
        int[] temp = Arrays.copyOf(score, score.length);
        Arrays.sort(score);
        int length = score.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : score)
            map.put(i, length--);
        String[] answer = new String[score.length];
        for (int i = 0; i < temp.length; i++){
            Integer num = map.get(temp[i]);
            if (num == 1) {
                answer[i] = "Gold Medal";
            } else if (num == 2) {
                answer[i] = "Silver Medal";
            } else if (num == 3) {
                answer[i] = "Bronze Medal";
            } else {
                answer[i] = num + "";
            }
        }
        return answer;
    }
}
