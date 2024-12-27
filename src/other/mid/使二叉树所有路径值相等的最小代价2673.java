package other.mid;

public class 使二叉树所有路径值相等的最小代价2673 {
    int ans = 0;
    int[] cost;
    public int minIncrements(int n, int[] cost) {
        this.cost = cost;
        dfs(0);
        return ans;
    }

    public void dfs(int node) {
        if (node * 2 + 2 >= cost.length) return;
        ans += Math.abs(cost[node * 2 + 1] - cost[node * 2 + 2]);
        dfs(node * 2 + 1);
        dfs(node * 2 + 2);
    }
}

class Test31 {
    public static void main(String[] args) {
        使二叉树所有路径值相等的最小代价2673 test = new 使二叉树所有路径值相等的最小代价2673();
        test.minIncrements(15, new int[]{764,1460,2664,764,2725,4556,5305,8829,5064,5929,7660,6321,4830,7055,3761});

    }
}
