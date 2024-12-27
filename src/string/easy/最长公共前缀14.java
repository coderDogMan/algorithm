package string.easy;

public class 最长公共前缀14 {
    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i)  != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

//    public static String longestCommonPrefix(String[] strs) {
//        int n = 0;
//        int i;
//        int j = 0;
//        String res  ="";
//        do {
//            for (i = 0; i < strs.length - 1; i++) {
//                if (strs[i].charAt(n) != strs[i + 1].charAt(n)) {
//                    for (int t = 0; j < n; j++) {
//                        res += strs[0].charAt(j);
//                    }
//                    return res;
//                };
//                if (i == strs.length - 1)  ++n;
//            }
//            j++;
//            n++;
//        } while (j < strs[0].length() - 1);
//
//        for (int t = 0; j < n; j++) {
//            res += strs[0].charAt(j);
//        }
//
//
//        return res;
//    }

}
