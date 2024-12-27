package week.gsdc.test8;

    import java.util.Scanner;

    public class T5 {



        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();



            while (t-- > 0) {
                Long n = in.nextLong();

                System.out.println(find(n + 1) - 1);
            }
        }

        //找 >=
        private static long find(Long n) {
            long l = 1;
            long r = (long) 1e9 + 2;
            while (l <= r) {
                long mid = (l + r) / 2;
                if (mid * mid >= n) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return l;

        }

    }
