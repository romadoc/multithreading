package login_test;

import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest {
    private Thread testThread;
    @BeforeClass
    public void beforeClass(ITestContext context) {
        testThread = Thread.currentThread();
        ThreadGroup group = testThread.getThreadGroup();
        int count = group.activeCount();
        Thread[] threads = new Thread[count];
        group.enumerate(threads);
        for (Thread thread : threads) {
            if (thread != null ) {
                System.out.println("Thread name: " + thread.getName());
            }
        }
    }

    @BeforeMethod
    public void renameThread() {
        Thread.currentThread().setName(this.getClass().getSimpleName());
        System.out.println("Thread newName: " + Thread.currentThread().getName());
    }
    @AfterMethod
    public void getTreadStatus() {
        System.out.println(Thread.currentThread().getName() + " Status AfterMethod " + Thread.currentThread().getState());
    }
    @AfterTest
    public void getTreadStatusAfterTest() {
        System.out.println(Thread.currentThread().getName() + " Status AfterTest " + Thread.currentThread().getState());
    }
    @AfterSuite
    public void getTreadStatusAfterSuite() {
        System.out.println(Thread.currentThread().getName() + " Status AfterSuite " + Thread.currentThread().getState());
    }

}
