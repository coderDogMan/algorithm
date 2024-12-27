package writtentest.roubao.weektwo112;

public class T1 {

        public boolean canBeEqual(String s1, String s2) {
            String c1 = String.valueOf(s1.charAt(0));
            String c2 = String.valueOf(s1.charAt(1));
            String c3 = String.valueOf(s1.charAt(2));
            String c4 = String.valueOf(s1.charAt(3));
            if (s1.equals(s2) || (c3 + c2 + c1 + c4).equals(s2) || (c1 + c4 + c3 + c2).equals(s2) || (c3 + c4 + c1 + c2).equals(s2)) return true;
            return false;

        }

}
