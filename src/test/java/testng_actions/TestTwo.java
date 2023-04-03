package testng_actions;

import multithread_actions.DataHolder;
import org.testng.annotations.*;

public class TestTwo {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite - testName: " + this.getClass().getSimpleName() + ", threadName: " + Thread.currentThread().getName() +
                ", ID - " + Thread.currentThread().getId());

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass - testName: " + this.getClass().getSimpleName() + ", threadName: " + Thread.currentThread().getName() +
                ", ID - " + Thread.currentThread().getId());

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest - testName: " + this.getClass().getSimpleName() + ", threadName: " + Thread.currentThread().getName() +
                ", ID - " + Thread.currentThread().getId());

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod - testName: " + this.getClass().getSimpleName() + ", threadName: " + Thread.currentThread().getName() +
                ", ID - " + Thread.currentThread().getId());

    }

    @Test
    public void runTest() {
        System.out.println(
                "  Class name: " + this.getClass().getSimpleName() +
                        ", Thread name before renaming: " + Thread.currentThread().getName() +
                        ", ID - " + Thread.currentThread().getId()
        );
        Thread.currentThread().setName("TestTwoName");
        System.out.println(
                "  Class name: " + this.getClass().getSimpleName() +
                "  , Thread name after renaming: " + Thread.currentThread().getName() +
                        ", ID - " + Thread.currentThread().getId()
        );

        System.out.println(this.getClass().getSimpleName() + "Deposit Before " + DataHolder.deposit);

        for (int i = 0; i < 20000 ; i++) {
            DataHolder.deposit--;
        }
        System.out.println(this.getClass().getSimpleName() + "Deposit After " + DataHolder.deposit);

        DataHolder dataHolder = new DataHolder();
        int j = dataHolder.sum + 1;
        System.out.println(this.getClass().getSimpleName() + "After " + j);

        int intInList = dataHolder.getIntegerList().get(0) + 2;
        System.out.println(intInList);
        dataHolder.getIntegerList().set(0, intInList);
        System.out.println(this.getClass().getSimpleName() + "After in list " + dataHolder.getIntegerList().get(0));
    }
}
