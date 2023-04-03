package multithread_actions;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerForClass {
    private static final ThreadLocal<org.apache.logging.log4j.Logger> LOGGER = ThreadLocal.withInitial(() -> LogManager.getLogger(Logger.class));
    private LoggerForClass() {
    }
    public static void info(String message){
        Allure.step(message);
        LOGGER.get().info(message);
    }
}
