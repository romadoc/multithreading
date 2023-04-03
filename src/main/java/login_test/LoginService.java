package login_test;

import com.codeborne.selenide.Selenide;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.open;

public class LoginService {
    private static List<LoginModel> loginModelList = getLoginModelList();

    private static List<LoginModel> getLoginModelList() {
        List<LoginModel> loginModelList = new ArrayList<>();
        Properties propertiy = new Properties();
        FileInputStream fileInputStream;
        String path = System.getProperty("user.dir") + "/src/main/java/login_test/develop.properties";

        try {
            fileInputStream = new FileInputStream(path);
            propertiy.load(fileInputStream);
            Set<String> stringSet = propertiy.stringPropertyNames();
            for (String key : stringSet) {
                LoginModel loginModel = new LoginModel();
                loginModel.setLogin(key);
                loginModel.setUrl(propertiy.getProperty(key));
                loginModelList.add(loginModel);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return loginModelList;
    }

    public void openPage() {
        getToNecessarySite();
    }

    private LoginModel getRandomLoginModel() throws InterruptedException {
        LoginModel result = null;
        while (result == null) {
            synchronized (loginModelList) {
                List<LoginModel> availableLoginModels = loginModelList.stream()
                        .filter(loginModel -> !loginModel.isInUse())
                        .collect(Collectors.toList());

                if (availableLoginModels.isEmpty()) {
                    System.out.println("No available login models, waiting...");
                    loginModelList.wait();
                } else {
                    int randomIndex = ThreadLocalRandom.current().nextInt(availableLoginModels.size());
                    result = availableLoginModels.get(randomIndex);
                    result.setInUse(true);
                }
            }
        }
        return result;
    }

    public void getToNecessarySite() {
        LoginModel loginModel = null;
        synchronized (loginModelList) {
            try {
                loginModel = getRandomLoginModel();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String login = loginModel.getLogin();
        String url = loginModel.getUrl();
        Thread.currentThread().setName("Thread " + login);
        System.out.println(Thread.currentThread().getName() + " login " + login + " url " + url);
        //open(url);

        synchronized (loginModel) {
            loginModel.setInUse(false);
            loginModel.notifyAll();
        }
    }

    public void releaseLoginModel(LoginModel loginModel) {
        synchronized (loginModelList) {
            loginModel.setInUse(false);
            // оповещаем другие потоки о доступных моделях
            loginModelList.notifyAll();
        }
        // закрываем браузер после использования
        Selenide.closeWebDriver();
    }
}