package course;

public class StarterWaiterInAccount {
    public static void main(String[] args) throws InterruptedException {
        WaiterInAccount waiterInAccount = new WaiterInAccount(20001L);
        System.out.println("begin " + waiterInAccount.getBalance());
        Runnable depositor = new Runnable() {
            @Override
            public void run() {
              waiterInAccount.deposit(1L);
            }
        };

        Runnable withdrawor = new Runnable() {
            @Override
//            public void run() {
//                waiterInAccount.withdraw(1L);
//            }
            public void run() {
                waiterInAccount.waitAndWithdraw(20000L);
            }
        };

        for (int i = 0; i < 20000; i++) {
            Thread thread = new Thread(depositor);
            Thread thread1 = new Thread(withdrawor);
            thread1.start();
            thread.start();
            thread.join();
            thread1.join();

        }
        System.out.println("end " + waiterInAccount.getBalance());
    }

}
