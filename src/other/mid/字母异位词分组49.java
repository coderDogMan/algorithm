package other.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 字母异位词分组49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if (map.containsKey(str)) {
                List<String> list = map.get(str);
                list.add(s);
                map.put(str, list);
            } else {
                ArrayList<String> item = new ArrayList<String>();
                item.add(s);
                map.put(str, item);
            }
        }
        return new ArrayList(map.values());
    }

}
