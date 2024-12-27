package other.mid;

public class 接雨水42 {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        maxLeft[0] = height[0];
        int[] maxRight = new int[height.length];
        maxRight[height.length - 1] = height[height.length - 1];
        //int[] ans = new int[height.length];
        int ans = 0;
        for (int i = 1; i < height.length; i++)
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        for (int i = height.length - 2; i >= 0; i--)
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ans;
    }
}

