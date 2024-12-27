package other.mid;

import java.util.HashMap;

public class FrequencyTracker {
    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> frequency;

    public FrequencyTracker() {
        map = new HashMap();
        frequency = new HashMap();
        frequency.put(0, 1);
    }

    public void add(int number) {
        int f = map.getOrDefault(number, 0);
        map.put(number, f + 1);
        frequency.put(f, frequency.get(f) - 1);
        frequency.put(f + 1, frequency.getOrDefault(f + 1, 0) + 1);
    }

    public void deleteOne(int number) {
        int f = map.getOrDefault(number, 0);
        if (f == 0) return;
        map.put(number, f - 1);
        frequency.put(f, frequency.getOrDefault(f, 0) - 1);
        frequency.put(f - 1, frequency.getOrDefault(f - 1, 0) + 1);
    }

    public boolean hasFrequency(int f) {
        return frequency.get(f) != null && frequency.get(f) != 0;
    }
}

class Test30 {
    public static void main(String[] args) {
        FrequencyTracker test = new FrequencyTracker();
        test.add(1);
        test.deleteOne(1);
        test.hasFrequency(1);
    }
}
