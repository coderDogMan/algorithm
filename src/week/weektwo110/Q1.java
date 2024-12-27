package week.weektwo110;

public class Q1 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int ten = purchaseAmount / 10;
        int ge = purchaseAmount % 5;
        if (ge >= 5) {
            return 100 - (ten + 1) * 10;
        } else {
            return 100 - (ten) * 10;
        }
    }
}
