package week.week393;

public class T1 {

    public String findLatestTime(String s) {
        String[] split = s.split(":");
        String h = split[0];
        String m = split[1];
        if (h.charAt(0) == '?') {
            if (h.charAt(1) != '?' && h.charAt(1) != '1' && h.charAt(1) != '0') {
                h = "0" + h.charAt(1);
            } else {
                h = "1" + h.charAt(1);
            }


        }
        if (h.charAt(1) == '?') {
            if (h.charAt(0) == '1') h = h.replace("?", "1");
            else h = h.replace('?', '9');
        }
        if (m.charAt(0) == '?') {
            m = "5" + m.charAt(1);
        }
        if (m.charAt(1) == '?') {
            m = m.replace('?', '9');
        }
        return h + ":" + m;
    }
}

class Test1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.findLatestTime( "1?:?4");
    }
}