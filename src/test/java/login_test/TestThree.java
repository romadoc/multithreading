package login_test;

import com.codeborne.selenide.Selenide;
import multithread_actions.LogInService;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestThree extends BaseTest {
    @Test
    public void printLogPass() {

        LoginService loginService = new LoginService();
        loginService.openPage();

        open("https://www.eldorado.ru/");

    }
}
