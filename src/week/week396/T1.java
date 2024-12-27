package week.week396;

/**
 * @Author: min
 * @Date:
 */
public class T1 {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        char[] yuan = {'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'};
        boolean flag1 = false;
        for (char c : yuan) {
            if (word.contains(c + "")) flag1 = true;
        }
        boolean flag2 = false;
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                for (int i = 0; i < yuan.length; i++) {
                    if (c == yuan[i]) {
                        break;
                    } else if (c != yuan[i] && i == yuan.length - 1) {
                        flag2 = true;
                    }
                }
            }
        }
        boolean flag3 = true;
        for (char c : word.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                continue;
            } else {
                flag3 = false;
            }
        }

        return flag1 && flag2 && flag3;

    }

}
