package login_test;

public class Observer {
    public void getMainTread() {
        Thread thread = new Thread(this::getMainTread);
        System.out.println("Main " + thread.getName());
    }

}
