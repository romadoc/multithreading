package testng_actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import multithread_actions.LogInService;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class WebTestTwo {
    @Test
    public void openTargetUrl2() {

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
