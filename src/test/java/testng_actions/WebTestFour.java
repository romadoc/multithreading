package testng_actions;

import multithread_actions.LogInService;
import org.testng.annotations.Test;

public class WebTestFour {
    @Test
    public void openTargetUrl() {

        LogInService logInService = new LogInService();
        logInService.openPage();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
