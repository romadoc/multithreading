package testng_simple;

import org.testng.annotations.Test;

public class TestOne {

    @Test
    public void runTest() {
        Thread.currentThread().setName("TestOneName");
        System.out.println(
                "Class name: " + this.getClass().getSimpleName() +
                ", Thread name: " + Thread.currentThread().getName()
        );
    }
}
