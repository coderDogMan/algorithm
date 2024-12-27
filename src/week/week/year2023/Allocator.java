package week.week.year2023;

public class Allocator {
    int[] nums;

    public Allocator(int n) {
        nums = new int[n];
    }

    public int allocate(int size, int mID) {
        int l = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && l == -1) {
                l = i;
            } else if (nums[i] != 0) {
                l = -1;
            }
            if (l != -1 && i - l + 1 >= size) {
                for (int j = l; j <= i; j++) {
                    nums[j] = mID;
                }
                return l;
            }
        }

        return -1;
    }

    public int free(int mID) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mID) {
                nums[i] = 0;
                ans++;
            }
        }
        return ans;
    }
}


class Test14 {
    public static void main(String[] args) {
        Allocator allocator = new Allocator(10);
        allocator.allocate(1, 1);
        allocator.allocate(1, 2);
        allocator.allocate(1, 3);
        allocator.free(2);
        allocator.allocate(3, 4);

        allocator.allocate(1, 1);
        allocator.allocate(1, 1);
        allocator.free(1);

        allocator.allocate(10, 2);
        allocator.free(7);
    }
}