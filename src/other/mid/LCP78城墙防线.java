package other.mid;

public class LCP78城墙防线 {
    int[][] rampart;
    int n;
    public int rampartDefensiveLine(int[][] rampart) {
        n = rampart.length;
        this.rampart = rampart;
        int l = 0;
        int r = rampart[n - 1][1] - rampart[0][1];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }

    public boolean check(int ex) {
        int pre = rampart[0][1];
        for (int i = 1; i < n - 1; i++) {
            int num = ex - (rampart[i][0] - pre);
            if (num > 0) {
                if (rampart[i + 1][0] - rampart[i][1] < num) {
                    return false;
                }
                pre = rampart[i][1] + num;
            } else {
                pre = rampart[i][1];
            }
        }
        return true;
    }
}

class Test32 {
    public static void main(String[] args) {
        LCP78城墙防线 test = new LCP78城墙防线();
        test.rampartDefensiveLine(new int[][]{
                {0,3},{4,5},{7,9}
        });
    }
}