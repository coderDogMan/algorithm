package week.week.year2024firstQuarter;

import java.util.HashMap;

public class 整数转罗马数字12 {
    public String intToRoman(int num) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        String[] dit = new String[] {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M",};
        StringBuilder stringBuilder = new StringBuilder();
        int idx = dit.length - 1;
        while (num > 0) {
            num -= map.get(dit[idx]);
            if (num >= 0) {
                stringBuilder.append(dit[idx]);
            } else {
                num += map.get(dit[idx]);
                idx--;
            }
        }
        return stringBuilder.toString();
    }
}
