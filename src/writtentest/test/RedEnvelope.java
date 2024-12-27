package writtentest.test;

import java.util.Arrays;
import java.util.Random;

public class RedEnvelope {
    public static void main(String[] args) {
        double n = 0.1;
        int m = 10;
        double[] ans = new double[m];

        for (int i = 0; i < m - 1; i++) {
            double x = n / (m - i) * 2 - 0.01;
            double cur = Math.random() * x  + 0.01;

            ans[i] = Math.floor(cur * 100) / 100;
            n -= ans[i];
        }
        ans[m - 1] = Math.floor(n * 100) / 100.0;
        double sum = 0;
        for (double an : ans) {
            sum += an;
        }
        System.out.println(ans);

    }

//    public static float[] redEnvelopes(float n, int m) {
//        float[] result = new float[m];
//        if(m == 1) {
//            result[0] = n;
//            return result;
//        }
//        for(int i = 0; i < m-1; i++) {
//            float tmp1 = n / (m - i) * 2 - 0.01f;
//            float tmp2 = 0.01f + (float) (tmp1 * Math.random());  // 产生[0.01~n/(m-i)*2)的随机数
//            result[i] = (float) (Math.floor(tmp2*100))/100;  // 乘以100在除以100是为了只保留两位小数
//            n -= result[i];
//        }
//        result[m-1] = (float) (Math.round(n*100))/100;
//        return result;
//    }


}
