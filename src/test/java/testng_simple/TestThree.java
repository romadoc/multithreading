package testng_simple;

import org.testng.annotations.Test;

public class TestThree {
    @Test
    public void runTest() {
        Thread.currentThread().setName("TestThreeName");
        System.out.println(
                "Class name: " + this.getClass().getSimpleName() +
                ", Thread name: " + Thread.currentThread().getName()
        );
    }
}
