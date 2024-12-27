package array.easy;

public class PlusOne {

    public static void main(String[] args) {
        plusOne(new int[]{9});
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >=0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;

    }


    //自己写的
//    public static int[] plusOne(int[] digits) {
//        int count = 0;
//        int start = 1;
//        for (int end = digits.length - 1; end >=0; end--) {
//            int temp = digits[end];
//
//            digits[end] = ((digits[end] + start + count) % 10);
//            count = (temp + count) / 10;
//            start = 0;
//        }
//
//        if (count != 0) {
//            int[] res = new int[digits.length + 1];
//            res[0] = 1;
//            for (int i = 0; i < digits.length; i++) {
//                res[i + 1] = digits[i];
//            }
//            return res;
//        }
//
//        return digits;
//    }

}
