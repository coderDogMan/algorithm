package writtentest.roubao;

public class 收款体款 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    bank.save(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    bank.get(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

class Bank {
    private int val;
    private int need;
    private boolean flag;

    public synchronized void save(int money) throws InterruptedException {
        val += money;
        System.out.println("已存入" + money + "元" + "，现在有" + val + "元");
        this.notify();
        this.wait();
        return;
    }

    public synchronized void get(int money) throws InterruptedException {
        need = money;
        System.out.println("需要" + need + "元");
        while (val < need) {
            this.notify();
            this.wait();
        }
        val -= need;
        System.out.println("取钱成功还剩" + val + "元");
        flag = true;
        this.notify();
        return;
    }



    public int getNeed() {
        return need;
    }

    public void setNeed(int need) {
        this.need = need;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
