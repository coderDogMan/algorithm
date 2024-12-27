package array.mid;

public class 最多能完成排序的块769 {
    public static void main(String[] args) {
        int i = maxChunksToSorted(new int[]{1,2,0,3});
    }
    public static int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
            }
        }
        return res;
    }
}
