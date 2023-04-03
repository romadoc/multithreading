package course;

public class InterrClass {
    static int cash = 100;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("start cicle ++ " + Thread.currentThread().getName() + " " + cash);
                        cash = cash + 1;
                        System.out.println("end cicle ++" + Thread.currentThread().getName() + " " + cash);
                    }
                    System.out.println("at the end plus action " + cash);
                }
            }
        };

        Runnable minusator = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("start cicle -- " + Thread.currentThread().getName() + " " + cash);
                        cash = cash - 1;
                        System.out.println("end cicle -- " + Thread.currentThread().getName() + " " + cash);
                    }
                    System.out.println("at the end of minusator " + cash);
                }
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(minusator);
        thread.start();
        thread1.start();

        System.out.println("after all cicles " + cash);
    }
}