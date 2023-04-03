package login_test;

import multithread_actions.LogInService;
import org.testng.annotations.Test;

public class TestOne extends BaseTest {
    @Test
    public void printLogPass() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        LoginService loginService = new LoginService();
        loginService.openPage();
        Observer observer = new Observer();
        observer.getMainTread();
    }

}
