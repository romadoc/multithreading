package course;

public class WaiterInAccount {
    private Long balance;
    public WaiterInAccount(Long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }


    public synchronized void deposit(long amount) {
            checkAmountNonNegative(amount);
            balance += amount;
            notifyAll(); //рассылает уведомления всем потокам, которые спят на мониторе, на котором мы синхронизируемся -
        // - на текущем объекте - экземпляре класса WaiterAccount
    }

    public synchronized void withdraw(long amount) {
            checkAmountNonNegative(amount);
            if (balance < amount) {
                System.out.println("non money");
            }
            balance -= amount;
    }

    public synchronized void waitAndWithdraw(long amount) {
        checkAmountNonNegative(amount);
        while (balance < amount) {
            try {
                wait(); //вызывается на текущем объекте - экземпляре класса WaiterAccount. синоним "this.wait"
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i've woke up!");
        }
        balance -= amount; //если денег достаточно, то снимает сумму и завершается, если денег мало, опять засыпает
    }

    private static void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }


}

