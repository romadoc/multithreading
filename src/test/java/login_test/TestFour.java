package login_test;

import org.testng.annotations.Test;

public class TestFour extends BaseTest {
    @Test
    public void printLogPass() {

        LoginService loginService = new LoginService();
        loginService.openPage();

    }
}
