package multithread_actions;

import java.io.FileInputStream;
import static com.codeborne.selenide.Selenide.open;
import java.io.IOException;
import java.util.*;

public class LogInService {
    private static Map<String, LoginModel> loginModelMap = getLoginModel();

    public void openPage() {
       // loginModelMap
        open();
        getToNecessarySite();

    }
    private static synchronized Map<String, LoginModel> getLoginModel() {
        Map<String, LoginModel> loginModelMap = new LinkedHashMap<>();
        Properties propertiy = new Properties();
        FileInputStream fileInputStream;
        String path = System.getProperty("user.dir") + "/src/main/java/multithread_actions/develop.properties";

        try {
            fileInputStream = new FileInputStream(path);
            propertiy.load(fileInputStream);
            Set<String> stringSet = propertiy.stringPropertyNames();
            for (String key : stringSet) {
                LoginModel loginModel = new LoginModel();
                loginModel.setLogin(key);
                loginModel.setUrl(propertiy.getProperty(key));
                loginModelMap.put(loginModel.getLogin(), loginModel);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return loginModelMap;
    }

    private synchronized  LoginModel getNextLoginModel() {
        LoginModel result = null;
        while (result == null) {
            for (LoginModel value : loginModelMap.values()) {
                if (!value.isInUse()) {
                    result = value;
                    value.setInUse(true);
                    break;
                }
            }
            if (result == null) {
                try {
                    this.wait();
                    System.out.println("Thread is sleeping " + Thread.currentThread().getName() );

                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

    public void getToNecessarySite() {
        LoginModel loginModel = getNextLoginModel();
        String login = loginModel.getLogin();
        Thread.currentThread().setName(login);
        String url = loginModel.getUrl(); //password
        System.out.println(login);

        open(url);

    }
}
