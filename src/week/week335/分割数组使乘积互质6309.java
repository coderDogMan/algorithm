package week.week335;

public class 分割数组使乘积互质6309 {
    public int findValidSplit(int[] nums) {
        int mod = 1000000009;
        int n = nums.length;
        long[] l = new long[n];
        long[] r = new long[n];
        l[0] = nums[0];
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] * nums[i] % mod;
        }
        r[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i] % mod;
        }
        for (int i = 0; i < n - 1; i++) {
            if (gcd(l[i], r[i + 1]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public long gcd(long a,long b){
        if(a%b==0)//若a能整除b则b为最大公约数
            return b;
        else
            return gcd(b,a%b);//否则进行递归
    }
}


class Test2 {
    public static void main(String[] args) {
        分割数组使乘积互质6309 test = new 分割数组使乘积互质6309();
        System.out.println(test.findValidSplit(new int[]{557663,280817,472963,156253,273349,884803,756869,763183,557663,964357,821411,887849,891133,453379,464279,574373,852749,15031,156253,360169,526159,410203,6101,954851,860599,802573,971693,279173,134243,187367,896953,665011,277747,439441,225683,555143,496303,290317,652033,713311,230107,770047,308323,319607,772907,627217,119311,922463,119311,641131,922463,404773,728417,948281,612373,857707,990589,12739,9127,857963,53113,956003,363397,768613,47981,466027,981569,41597,87149,55021,600883,111953,119083,471871,125641,922463,562577,269069,806999,981073,857707,831587,149351,996461,432457,10903,921091,119083,72671,843289,567323,317003,802129,612373}));
//        System.out.println(test.findValidSplit(new int[]{2, 3, 3}));
//        System.out.println(test.findValidSplit(new int[]{4,7,8,15,3,5}));
//        System.out.println(test.findValidSplit(new int[]{4,7,15,8,3,5}));

    }
}
