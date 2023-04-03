package course;

public class Interruption {
    public static void main(String[] args) throws InterruptedException {

        WorkerThread workerThread = new WorkerThread();
        Sleeper sleeper = new Sleeper();

        System.out.println("Threads start");
        workerThread.start();
        sleeper.start();

        Thread.sleep(100L);

        System.out.println("Interrupted thread");
        workerThread.interrupt();
        sleeper.interrupt();

        System.out.println("Joining threads");
        workerThread.join();
        sleeper.join();

        System.out.println("All done");


    }
    private static class WorkerThread extends Thread {

        public void run() {
            long sum = 0;
            for (int i = 0; i < 1_000_000_000; i ++) {
                sum += i;
                if(i % 100 == 0 && isInterrupted()) {
                    System.out.println("Loop is interrupted!");
                    break;
                }
            }
        }
    }

    private static class Sleeper extends Thread {
        public void run() {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                System.out.println("Sleep is interrupted");
            }
        }
    }
}
