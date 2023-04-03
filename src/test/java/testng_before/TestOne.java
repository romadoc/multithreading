package testng_before;

import org.testng.annotations.*;

public class TestOne {

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
    @BeforeGroups
    public void beforeGroups() {
        System.out.println("BeforeGroups - testName: " + this.getClass().getSimpleName() +
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
        Thread.currentThread().setName("TestOneName");
        System.out.println(
                "  Class name: " + this.getClass().getSimpleName() +
                ", Thread name after renaming: " + Thread.currentThread().getName() +
                        ", ID - " + Thread.currentThread().getId()
        );
    }
}
