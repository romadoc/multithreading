package login_test;

import multithread_actions.LogInService;
import org.testng.annotations.Test;

public class TestTwo extends BaseTest {
    @Test
    public void printLogPass() {

        LoginService loginService = new LoginService();
        loginService.openPage();
    }
}
