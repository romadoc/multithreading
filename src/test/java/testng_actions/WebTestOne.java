package testng_actions;

import com.codeborne.selenide.WebDriverRunner;
import multithread_actions.LogInService;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class WebTestOne {
    @Test
    public void openTargetUrl1() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
