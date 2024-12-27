package array.mid;

public class 盛最多水的容器 {

    public static void main(String[] args) {
        int i = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (height[i] <= height[j]) {
                int temp = (j - i) * height[i];
                area = area > temp ? area : temp;
                i++;
            } else {
                int temp = (j - i) * height[j];
                area = area > temp ? area : temp;
                j--;
            }
        }
        return area;
    }
}
