package testng_actions;

import com.codeborne.selenide.WebDriverRunner;
import multithread_actions.LogInService;
import org.testng.annotations.Test;

public class WebTestThree {
    @Test
    public void openTargetUrl3() {

        LogInService logInService = new LogInService();
        logInService.openPage();
        System.out.println("Class name" + this.getClass().getSimpleName() + "Thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            WebDriverRunner.getWebDriver().quit();
        }


    }
}
