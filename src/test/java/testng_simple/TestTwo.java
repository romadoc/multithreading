package testng_simple;

import org.testng.annotations.Test;

public class TestTwo {
    @Test
    public void runTest() {
        Thread.currentThread().setName("TestTwoName");
        System.out.println(
                "Class name: " + this.getClass().getSimpleName() +
                ", Thread name: " + Thread.currentThread().getName()
        );
    }
}
