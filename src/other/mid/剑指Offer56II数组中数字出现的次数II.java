package other.mid;

public class 剑指Offer56II数组中数字出现的次数II {
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < 32; k++) {
                arr[k] += nums[i] & 1;
                nums[i] >>= 1;
            }
        }
        // 低 -> 高
        int ans = 0;
        for (int k = 0; k < 32; k++) {
            ans <<= 1;
            if(arr[31 - k] % 3 != 0) {
                ans |= 1;
            }
        }
        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
        剑指Offer56II数组中数字出现的次数II test = new 剑指Offer56II数组中数字出现的次数II();
        test.singleNumber(new int[]{3,4,3,3});
    }
}
