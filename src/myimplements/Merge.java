package myimplements;

public class Merge {
    int[] temp;
    public Merge(int n) {
        temp = new int[n];
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;



        int mid = (l + r) / 2;
        mergeSort(nums, l ,mid);
        mergeSort(nums, mid + 1 ,r);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++)
            temp[k] = nums[k];

        for (int k = l; k <= r; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if(j == r + 1 || temp[i] < temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = nums[j++];
            }
        }

    }
}


class Test {
    public static void main(String[] args) {
        Merge merge = new Merge(4);
        int[] nums = new int[]{7,5,6,4};
        merge.mergeSort(nums, 0, 3);
        System.out.println(nums);
    }
}

class Main2 {
    static int[] temp;
    public static void main(String[] args) {
        int[] nums = {1, 2, 44, 5, 6, 1};
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return;
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        for (int i = l; i <= r; i++) temp[i] = nums[i];
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == r + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] < temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }


    }
}