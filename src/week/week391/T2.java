package week.week391;

public class T2 {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles - numExchange >= 0) {
            ans++;
            numBottles -= numExchange;
            numBottles++;
            numExchange++;
        }
        return ans;
    }
}

class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.maxBottlesDrunk(13, 6);
    }
}