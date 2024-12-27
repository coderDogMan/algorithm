package week.lcp2023;

import java.util.HashSet;

public class T2 {
    public int adventureCamp(String[] expeditions) {
        int ans = -1;
        int max = 0;
        String[] strings = expeditions[0].split("->");
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < strings.length; i++) {
            if (!set.contains(strings[i]))
                set.add(strings[i]);
        }
        for (int i = 1; i < expeditions.length; i++) {
            strings = expeditions[i].split("->");
            if (strings[0].equals(""))continue;
            int num = 0;
            for (int j = 0; j < strings.length; j++) {
                if (!set.contains(strings[j])) {
                    set.add(strings[j]);
                    num++;
                }
            }
            if (num > max) {
                ans = i;
                max = num;
            }
        }
        return ans;
    }
}

class Test2 {
    public static void main(String[] args) {
        T2 test = new T2();
        test.adventureCamp(new String[]{
                "Alice->Dex","","Dex"
        });

    }
}
