package course;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> System.out.println("hi")).start();
//        }
        HelloRunnable helloRunnable = new HelloRunnable();
        for (int i = 0; i < 10; i ++) {
            new Thread(helloRunnable).start();
        }

    }
    static class HelloRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("HelloFrom runnable " + Thread.currentThread().getId());
        }
    }

}