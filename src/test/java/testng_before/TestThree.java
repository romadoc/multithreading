package testng_before;

import org.testng.annotations.*;

public class TestThree {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite - testName: " + this.getClass().getSimpleName() +
                ", threadName: " + Thread.currentThread().getName() +
                ", ID - " + Thread.currentThread().getId());

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass - testName: " + this.getClass().getSimpleName() +
                ", threadName: " + Thread.currentThread().getName() +
                ", ID - " + Thread.currentThread().getId());

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest - testName: " + this.getClass().getSimpleName() +
                ", threadName: " + Thread.currentThread().getName() +
                ", ID - " + Thread.currentThread().getId());

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod - testName: " + this.getClass().getSimpleName() +
                ", threadName: " + Thread.currentThread().getName() +
                ", ID - " + Thread.currentThread().getId());

    }

    @Test
    public void runTest() {
        System.out.println(
                "  Class name: " + this.getClass().getSimpleName() +
                        ", Thread name before renaming: " + Thread.currentThread().getName() +
                        ", ID - " + Thread.currentThread().getId()
        );
        Thread.currentThread().setName("TestThreeName");
        System.out.println(
                "  Class name: " + this.getClass().getSimpleName() +
                "  , Thread name after renaming: " + Thread.currentThread().getName() +
                        ", ID - " + Thread.currentThread().getId()
        );
    }
}
