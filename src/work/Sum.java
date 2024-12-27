package work;

public class Sum {

    private int sum;

    public Sum() {
        this.sum = 0;
    }

    public Sum(int sum) {
        this.sum = sum;
    }

    public int getSum(int left, int right) {
        return (left + right) * (right - left + 1) / 2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}

